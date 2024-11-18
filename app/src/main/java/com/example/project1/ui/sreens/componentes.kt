package com.example.project1.ui.sreens

import android.os.Build
import android.content.Intent
import androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_STRONG
import androidx.biometric.BiometricManager.Authenticators.DEVICE_CREDENTIAL
import android.provider.Settings
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.window.core.layout.WindowHeightSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import com.example.project1.R
import com.example.project1.clases.BiometricPromptManager
import com.example.project1.clases.BiometricPromptManager.BiometricResult
import com.example.project1.ui.sreens.ProfileScreen
import com.example.project1.data.model.MenuModel
import com.example.project1.data.model.PostModel
import com.example.project1.data.model.Reminder
import com.example.project1.ui.components.PostCard
import com.example.project1.ui.components.PostCardCompact
import com.example.project1.ui.viewmodel.ReminderViewModel
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@Composable
fun Components(navController: NavController, promptManager: BiometricPromptManager) {
    val menuOptions = arrayOf(
        MenuModel(1, "Buttons", "buttons", Icons.Filled.AccountBox),
        MenuModel(2, "Floating Buttons", "floating-buttons", Icons.Filled.DateRange),
        MenuModel(3, "Chips", "chips", Icons.Filled.AccountBox),
        MenuModel(4, "Progress", "progress", Icons.Filled.AccountBox),
        MenuModel(5, "Sliders", "sliders", Icons.Filled.AccountBox),
        MenuModel(6, "Switches", "switches", Icons.Filled.AccountBox),
        MenuModel(7, "Badges", "badges", Icons.Filled.AccountBox),
        MenuModel(8, "Date Pickers", "date-pickers", Icons.Filled.AccountBox),
        MenuModel(9, "Time Pickers", "time-pickers", Icons.Filled.AccountBox),
        MenuModel(10, "Snack Bars", "snack-bars", Icons.Filled.AccountBox),
        MenuModel(11, "Alert Dialogs", "alert-dialogs", Icons.Filled.AccountBox),
        MenuModel(12, "Bars", "bars", Icons.Filled.AccountBox),
        MenuModel(13, "Adaptive", "adaptive", Icons.Filled.AccountBox),
        MenuModel(14, "ReminderApp", "reminder", Icons.Filled.AccountBox)
        MenuModel(17, "HomeScreen", "home-screen", Icons.Filled.AccountCircle)
  )
    var component by rememberSaveable { mutableStateOf("") }//actualizar el valor de la variable en la interfaz
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState, //current state of drawer
        // drawer content
        drawerContent = {
            ModalDrawerSheet {
                Text("Menu", modifier = Modifier.padding(16.dp))
                HorizontalDivider()
                LazyColumn {
                    items(menuOptions) {item ->
                        NavigationDrawerItem(
                            icon = {Icon(item.icon, contentDescription = "")},
                            label = {Text(text= item.title)},
                            selected = false,
                            onClick = {
                                component = item.option
                                scope.launch {
                                    drawerState.apply {
                                        close()
                                    }
                                }
                            }
                        )
                    }
                }

            }
        }
    ) {
        //screen content
        Column {
            when (component) {
                "Buttons" -> {
                    Buttons()
                }
                "floating-buttons" -> {
                    FloatingButtons()
                }
                "chips" -> {
                    Chips()
                }
                "progress" -> {
                    Progress()
                }
                "sliders" -> {
                    Sliders()
                }
                "switches" -> {
                    Switches()
                }
                "badges" -> {
                    Badges()
                }
                "date-pickers" -> {
                    DatePickers()
                }
                "time-pickers" -> {
                    TimePickers(onConfirm = { hour, minute ->
                        println("Tiempo seleccionado: $hour:$minute")
                    },
                        onDismiss = {
                            println("TimePicker descartado")
                        })
                }
                "snack-bars" -> {
                    SnackBars()
                }
                "alert-dialogs" -> {
                    AlertDialogs()
                }
                "bars" -> {
                    Bars()
                }
                "adaptive" -> {
                    Adaptive()
                }
                "home-screen" -> {
                    ProfileScreen(navController)
                "reminder" -> {
                    ReminderApp()
                }
            }
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun Buttons() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Button(onClick = {}) {
            Text("Filled")
        }
        FilledTonalButton(onClick = {}) {
            Text("Tonal")
        }
        OutlinedButton(onClick = {}) {
            Text("Tonal")
        }
        ElevatedButton(onClick = {}) {
            Text("Elevated")
        }
        TextButton(onClick = {}) {
            Text("Text")
        }

    }
}

//@Preview (showBackground = true)
@Composable
fun FloatingButtons() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        FloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.Add, "")
        }
        SmallFloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.Add, "")
        }
        LargeFloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.Add, "")
        }
        ExtendedFloatingActionButton(onClick = {},
            icon = { Icon(Icons.Filled.Add, "") },
            text = { Text(text = "Estended FAB") }
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun Chips() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        AssistChip(
            onClick = {},
            label = { Text("Assist C") },
            leadingIcon = {
                Icon(
                    Icons.Filled.Done, "",
                    Modifier.size(AssistChipDefaults.IconSize)
                )
            }
        )
        var selected by remember { mutableStateOf(false) }
        FilterChip(
            selected = selected,
            onClick = {},
            label = { Text("Filled C") },
            /*leadingIcon = {
                if (selected) {
                    Icon(
                        Icons.Filled.Done, "",
                        Modifier.size(AssistChipDefaults.IconSize)
                    )
                } else {
                    null
                }
            }*/
            leadingIcon = if (selected) {
                {
                    Icon(
                        Icons.Filled.Done, "",
                        Modifier.size(AssistChipDefaults.IconSize)
                    )
                }
            } else {
                null
            }
        )
        InputChipExample("Dissmiss", {/*Ira vacia la funcion*/ })
    }
}

//@Preview(showBackground = true)
@Composable
fun InputChipExample(
    text: String,
    onDismiss: () -> Unit
) {
    var enabled by remember { mutableStateOf(true) }
    if (!enabled) return

    InputChip(
        label = { Text(text) },
        selected = enabled,
        onClick = {
            onDismiss()
            enabled = !enabled
        },
        avatar = {
            Icon(
                Icons.Filled.Person,
                contentDescription = "",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        },
        trailingIcon = {
            Icon(
                Icons.Filled.Close,
                contentDescription = "",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        }
    )
}

//@Preview(showBackground = true)
@Composable
fun Progress() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth()
        )
        CircularProgressIndicator(
            modifier = Modifier.width(64.dp)
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun Sliders() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        var sliderPosition by remember { mutableStateOf(50f) }
        Column {
            Slider(
                value = sliderPosition,
                onValueChange = { sliderPosition = it },
                steps = 10,
                valueRange = 0f..100f
            )
            Text(
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                text = sliderPosition.toString()
            )
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun Switches() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        var checked by remember { mutableStateOf(true) }
        Switch(
            checked = checked,
            onCheckedChange = {
                checked = it
            }
        )
        var checked2 by remember { mutableStateOf(true) }
        Switch(
            checked = checked2,
            onCheckedChange = {
                checked2 = it
            },
            thumbContent = if (checked2) {
                {
                    Icon(
                        Icons.Filled.Person,
                        contentDescription = "",
                        Modifier.size(InputChipDefaults.AvatarSize)
                    )
                }
            } else {
                null
            }
        )

        var checked3 by remember { mutableStateOf(true) }
        Checkbox(
            checked = checked3,
            onCheckedChange = { checked3 = it }
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun Badges() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        var itemCount by remember { mutableStateOf(0) }

        BadgedBox(
            badge = {
                if (itemCount > 0) {
                    Badge(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    ) {
                        Text("${itemCount}")
                    }
                }
            }
        ) {
            Icon(
                Icons.Filled.ShoppingCart,
                contentDescription = "",
            )
        }
        Button(
            onClick = { itemCount++ }
        ) {
            Text("Add text item")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true)
@Composable
fun TimePickers(
    onConfirm: (hour: Int, minute: Int) -> Unit,
    onDismiss: () -> Unit,
) {
    val currentTime = Calendar.getInstance()

    val timePickerState = rememberTimePickerState(
        initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
        initialMinute = currentTime.get(Calendar.MINUTE),
        is24Hour = true,
    )

    Column {
        TimeInput(
            state = timePickerState,
        )
        Button(onClick = onDismiss) {
            Text("Quitar")
        }
        Button(onClick = { onConfirm(timePickerState.hour, timePickerState.minute) }) {
            Text("Confirmar")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true)
@Composable
fun DatePickers() {
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()
    val selectedDate = datePickerState.selectedDateMillis?.let {
        convertMillisToDate(it)
    } ?: ""

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = selectedDate,
            onValueChange = { },
            label = { Text("DOB") },
            readOnly = true,
            trailingIcon = {
                IconButton(onClick = { showDatePicker = !showDatePicker }) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Select date"
                    )
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
        )

        if (showDatePicker) {
            Popup(
                onDismissRequest = { showDatePicker = false },
                alignment = Alignment.TopStart
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = 64.dp)
                        .shadow(elevation = 4.dp)
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(16.dp)
                ) {
                    DatePicker(
                        state = datePickerState,
                        showModeToggle = false
                    )
                }
            }
        }
    }

}

fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
    return formatter.format(Date(millis))
}

//@Preview(showBackground = true)
@Composable
fun SnackBars() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        val snackState = remember { SnackbarHostState() }
        val snackScope = rememberCoroutineScope()

        SnackbarHost(hostState = snackState, Modifier)

        fun launchSnackbar() {
            snackScope.launch { snackState.showSnackbar("The message was sent") }
        }

        Button(::launchSnackbar) {
            Text("Show snackbar")
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun AlertDialogs() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        var showAlertDialog by remember { mutableStateOf(false) }
        var selectedOption by remember { mutableStateOf("") }

        if (showAlertDialog) {
            AlertDialog(
                icon = { Icon(Icons.Filled.Warning, "") },
                title = { Text("Confirm deletion") },
                text = { Text("Are you sure you want to delete this file=") },
                onDismissRequest = { },
                confirmButton = {
                    TextButton(
                        onClick = {
                            selectedOption = "Confirm"
                            showAlertDialog = false
                        }
                    ) {
                        Text("Confirm")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            selectedOption = "Dismiss"
                            showAlertDialog = false
                        }
                    ) {
                        Text("Dismiss")
                    }
                }
            )
        }
        Text(selectedOption)
        Button(onClick = { showAlertDialog = true }) {
            Text("Show alert dialog")
        }
    }
}

//@Preview (showBackground = true)
@Composable
fun Bars() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.DarkGray)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .background(Color.Black)
                .padding(10.dp, 50.dp, 10.dp, 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            Icon(Icons.Filled.Menu, contentDescription = "", tint = Color.White)
            Text(text = "App Title",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp)
            Icon(Icons.Filled.Settings, contentDescription = "", tint = Color.White)
        }
        val post = arrayOf(
            PostModel(1, "Title 1", "Text 1", painterResource(R.drawable.android_logo)),
            PostModel(2, "Title 2", "Text 2", painterResource(R.drawable.android_logo)),
            PostModel(3, "Title 3", "Text 3", painterResource(R.drawable.android_logo)),
            PostModel(4, "Title 4", "Text 4", painterResource(R.drawable.android_logo)),
            PostModel(5, "Title 5", "Text 4", painterResource(R.drawable.android_logo)),
            PostModel(6, "Title 6", "Text 4", painterResource(R.drawable.android_logo)),
            PostModel(7, "Title 7", "Text 4", painterResource(R.drawable.android_logo))
        )
        Column (
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(10.dp,90.dp,10.dp,50.dp)
                .fillMaxSize()
                //.verticalScroll(rememberScrollState())
        ){
            //PostCard(1,"This is a card title","This is the text card", painterResource(R.drawable.android_logo))
            //Posts(post)
            PostGrid(post)

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .height(65.dp)
                .background(Color.Black)
                .padding(2.dp, 5.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Column {
                IconButton(onClick = {}, Modifier.size(30.dp))  {
                    Icon(Icons.Outlined.Home,
                        contentDescription = "",
                        tint = Color.White,
                        modifier = Modifier.fillMaxSize())
                }
                Text(text = "Home", color = Color.White)
            }
            Column {
                IconButton(onClick = {}, Modifier.size(30.dp))  {
                    Icon(Icons.Outlined.Favorite,
                        contentDescription = "",
                        tint = Color.White,
                        modifier = Modifier.fillMaxSize())
                }
                Text(text = "Favorite", color = Color.White)
            }
            Column {
                IconButton(onClick = {}, Modifier.size(30.dp))  {
                    Icon(Icons.Outlined.PlayArrow,
                        contentDescription = "",
                        tint = Color.White,
                        modifier = Modifier.fillMaxSize())
                }
                Text(text = "Play", color = Color.White)
            }
            Column {
                IconButton(onClick = {}, Modifier.size(30.dp))  {
                    Icon(Icons.Outlined.Build,
                        contentDescription = "",
                        tint = Color.White,
                        modifier = Modifier.fillMaxSize())
                }
                Text(text = "Build", color = Color.White)
            }
            Column {
                IconButton(onClick = {}, Modifier.size(30.dp))  {
                    Icon(Icons.Outlined.AccountBox,
                        contentDescription = "",
                        tint = Color.White,
                        modifier = Modifier.fillMaxSize())
                }
                Text(text = "Account", color = Color.White)
            }
        }
    }
}

@Composable
fun Posts(arrayPosts: Array<PostModel>, adaptive:String){
    //Espera a que llegue la info para que se ejecute
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
    ) {//Se repetira este texto lo que queramos (creo xdd)
        items(arrayPosts) { post ->
            when(adaptive){
                "PhoneP" -> {
                    PostCardCompact(post.id, post.title, post.text, post.image)
                }
                "PhoneL" -> {
                    PostCard(post.id, post.title, post.text, post.image)
                }
            }
        }
    }
}

@Composable
fun PostGrid(arrayPosts: Array<PostModel>){
    LazyVerticalGrid (
        columns = GridCells.Adaptive(minSize = 120.dp),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        items(arrayPosts) { post ->
            PostCard(post.id, post.title, post.text, post.image)
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun Adaptive(){
    var WindowsSize = currentWindowAdaptiveInfo().windowSizeClass
    var height = currentWindowAdaptiveInfo().windowSizeClass.windowHeightSizeClass
    var width = currentWindowAdaptiveInfo().windowSizeClass.windowWidthSizeClass

    val post = arrayOf(
        PostModel(1, "Title 1", "Text 1", painterResource(R.drawable.android_logo)),
        PostModel(2, "Title 2", "Text 2", painterResource(R.drawable.android_logo)),
        PostModel(3, "Title 3", "Text 3", painterResource(R.drawable.android_logo)),
        PostModel(4, "Title 4", "Text 4", painterResource(R.drawable.android_logo)),
        PostModel(5, "Title 5", "Text 4", painterResource(R.drawable.android_logo)),
        PostModel(6, "Title 6", "Text 4", painterResource(R.drawable.android_logo)),
        PostModel(7, "Title 7", "Text 4", painterResource(R.drawable.android_logo))
    )
    if (width == WindowWidthSizeClass.COMPACT){
        Posts(post, "PhoneP")
    } else if (height == WindowHeightSizeClass.COMPACT){
        Posts(post, "PhoneL")
    } else {
        Posts(post, "Phone")
    }

    /*    Compact width < 600 dp Phone portrait
    Medium width >= 600 dp < 840 dp Tablets portrait
    Expanded width > 840 dp Tablet landscape
    Compact height < 480dp Phone landscape
    Medium height >= 480dp < 900 dp Tablet landscape or Phone portrait
    Expanded height > 900dp Tablet in portrait    */

    //Text(text = WindowsSize.toString())
}

@Composable
fun HomeScreen(navController : NavController,promptManager: BiometricPromptManager){

    Column(
        modifier = Modifier.fillMaxSize()
    ){
        LazyColumn{
            item {
                profileRow(navController,promptManager)

            }
            items(2){
                Image(
                    painter = painterResource(id = R.drawable.android_logo),
                    contentDescription = "android logo",
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

    }
}

@Composable
fun profileRow(navController : NavController,promptManager:BiometricPromptManager){

    val biometricResult by promptManager.promptResults.collectAsState(initial = null)
    val enrollLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult(),
        onResult = {
            println("Activity result: $it")
        }
    )
    LaunchedEffect(biometricResult) {
        if(biometricResult is BiometricResult.AuthenticationNotSet){
            if(Build.VERSION.SDK_INT >= 30){
                val enrollIntent = Intent(Settings.ACTION_BIOMETRIC_ENROLL).apply {
                    putExtra(
                        Settings.EXTRA_BIOMETRIC_AUTHENTICATORS_ALLOWED,
                        BIOMETRIC_STRONG or DEVICE_CREDENTIAL
                    )
                }
                enrollLauncher.launch(enrollIntent)
            }
        }
    }
    Row(
        modifier = Modifier
            .padding(10.dp)
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RoundedCornerShape(12.dp)
            )
            .fillMaxWidth(),

        horizontalArrangement = Arrangement.SpaceBetween
    ){
        profileInfo()
        TextButton(
            onClick = {
                promptManager.showBiometricPrompt(
                    title = "Authenticate",
                    description = "Please, identify yourself"
                )
            }
        ) {
            Text("Edit")
        }

        biometricResult?.let{
                result ->
            when(result){
                is BiometricPromptManager.BiometricResult.AuthenticationSuccess -> {
                    if (navController.currentDestination?.route != "profile") {
                        navController.navigate("profile")
                    }
                }
                else ->{
                }
            }
        }
    }
}

@Composable
fun profileInfo(){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            imageVector = Icons.Filled.AccountCircle,
            contentDescription = "Profile icon",
            modifier=Modifier.size(50.dp)

        )
        Text(
            "Profile",
            modifier = Modifier.padding(horizontal = 10.dp),
            fontSize = 18.sp
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReminderApp() {
    val viewModel: ReminderViewModel = viewModel()
    val reminders by viewModel.reminders.collectAsState()
    var showDialog by remember { mutableStateOf(false) }
    var showDatePicker by remember { mutableStateOf(false) }
    var showTimePicker by remember { mutableStateOf(false) }
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var selectedDate by remember { mutableStateOf(Calendar.getInstance()) }
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Recordatorios") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { showDialog = true }) {
                Text("+")
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            // Lista de recordatorios
            items(reminders) { reminder ->
                ReminderItem(
                    reminder = reminder,
                    onDelete = { viewModel.deleteReminder(context, reminder) }
                )
            }
        }

        // agregar recordatorio
        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Nuevo Recordatorio") },
                text = {
                    Column {
                        TextField(
                            value = title,
                            onValueChange = { title = it },
                            label = { Text("Título") }
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        TextField(
                            value = description,
                            onValueChange = { description = it },
                            label = { Text("Descripción") }
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        // Boton para mostrar DatePicker
                        Button(
                            onClick = { showDatePicker = true }
                        ) {
                            Text(
                                "Seleccionar Fecha: ${
                                    SimpleDateFormat(
                                        "dd/MM/yyyy",
                                        Locale.getDefault()
                                    ).format(selectedDate.time)
                                }"
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        // Boton para mostrar TimePicker
                        Button(
                            onClick = { showTimePicker = true }
                        ) {
                            Text(
                                "Seleccionar Hora: ${
                                    SimpleDateFormat(
                                        "HH:mm",
                                        Locale.getDefault()
                                    ).format(selectedDate.time)
                                }"
                            )
                        }
                    }
                },
                confirmButton = {
                    Button(onClick = {
                        viewModel.addReminder(
                            context,
                            title,
                            description,
                            selectedDate.timeInMillis
                        )
                        title = ""
                        description = ""
                        showDialog = false
                    }) {
                        Text("Guardar")
                    }
                },
                dismissButton = {
                    Button(onClick = { showDialog = false }) {
                        Text("Cancelar")
                    }
                }
            )
        }

        // DatePicker
        if (showDatePicker) {
            val datePickerState = rememberDatePickerState(
                initialSelectedDateMillis = selectedDate.timeInMillis
            )

            DatePickerDialog(
                onDismissRequest = { showDatePicker = false },
                confirmButton = {
                    TextButton(onClick = {
                        datePickerState.selectedDateMillis?.let { dateMillis ->
                            val newDate = Calendar.getInstance().apply {
                                timeInMillis = dateMillis
                            }
                            selectedDate.set(
                                newDate.get(Calendar.YEAR),
                                newDate.get(Calendar.MONTH),
                                newDate.get(Calendar.DAY_OF_MONTH)
                            )
                        }
                        showDatePicker = false
                    }) {
                        Text("OK")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDatePicker = false }) {
                        Text("Cancelar")
                    }
                }
            ) {
                DatePicker(
                    state = datePickerState,
                    showModeToggle = false
                )
            }
        }

        // TimePicker
        if (showTimePicker) {
            TimePickerDialog(
                onDismissRequest = { showTimePicker = false },
                onConfirm = { hour, minute ->
                    selectedDate.set(Calendar.HOUR_OF_DAY, hour)
                    selectedDate.set(Calendar.MINUTE, minute)
                    showTimePicker = false
                }
            )
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerDialog(
    onDismissRequest: () -> Unit,
    onConfirm: (Int, Int) -> Unit
) {
    val currentTime = Calendar.getInstance()

    val timePickerState = rememberTimePickerState(
        initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
        initialMinute = currentTime.get(Calendar.MINUTE),
        is24Hour = true
    )

    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = { Text("Seleccionar hora") },
        text = {
            Column(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TimePicker(state = timePickerState)
            }
        },
        confirmButton = {
            TextButton(
                onClick = { onConfirm(timePickerState.hour, timePickerState.minute) }
            ) {
                Text("OK")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismissRequest) {
                Text("Cancelar")
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReminderItem(reminder: Reminder, onDelete: () -> Unit) {
    val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = reminder.title,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = reminder.description,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = dateFormat.format(Date(reminder.dateTime)),
                style = MaterialTheme.typography.bodySmall
            )
            Button(
                onClick = onDelete,
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text("Eliminar")
            }
        }
    }
}