package com.example.project1.ui.sreens

import android.Manifest
import android.content.ContentValues
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import java.io.IOException

@Composable
fun rememberPermissionLauncher(
    context: Context,
    onPermissionResult: (Boolean) -> Unit
): ActivityResultLauncher<Array<String>> {
    return rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        val allPermissionsGranted = permissions.entries.all { it }
        if (!allPermissionsGranted) {
            Toast.makeText(
                context,
                "Permisos camara",
                Toast.LENGTH_SHORT
            ).show()
            onPermissionResult(allPermissionsGranted)
        }
    }
}

@Composable
fun rememberCameraLauncher(
    context: Context,
    onBitmapCaptured: (Uri?) -> Unit
): ActivityResultLauncher<Void?> {
    return rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview()
    ) { bitmap ->
        bitmap?.let {
            val uri = saveBitmapToFile(it, context)
            onBitmapCaptured(uri)
        }
    }
}

@Composable
fun rememberGalleryLauncher(
    context: Context,
    permissionsLauncher: ActivityResultLauncher<Array<String>>,
    action: (Any?) -> Unit
) {
    val cameraPermission = android.Manifest.permission.CAMERA
    val storagePermission = if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    } else null

    val permissionToRequest = listOfNotNull(cameraPermission, storagePermission).filter {
        context.checkSelfPermission(it) != PackageManager.PERMISSION_GRANTED
    }

    if (permissionToRequest.isNotEmpty()) {
        permissionsLauncher.launch(permissionToRequest.toTypedArray())
    } else {
        action()
    }
}

@Composable
fun saveBitmapToFile(bitmap: Bitmap, context: Context): Uri? {
    val contentValues = ContentValues().apply {
        put(MediaStore.Images.Media.DISPLAY_NAME, "image_${System.currentTimeMillis()}.jpg")
        put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
        put(MediaStore.Images.Media.RELATIVE_PATH, Environment.DIRECTORY_PICTURES)
    }

    val uri = context.contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)

    uri?.let {
        try {
            context.contentResolver.openOutputStream(it)?.use { outputStream ->
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
            }
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }
    }
    return uri
}