package com.example.project1.data.model

import androidx.compose.ui.graphics.vector.ImageVector
import java.io.StringBufferInputStream

data class MenuModel(
    val id: Int,
    val title: String,
    val option: String,
    val icon: ImageVector
)
