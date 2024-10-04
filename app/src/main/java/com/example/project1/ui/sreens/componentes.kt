package com.example.project1.ui.sreens

import android.content.res.AssetManager.AssetInputStream
import android.service.voice.VoiceInteractionSession.AssistState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DatePicker
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
import androidx.compose.material3.Slider
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.navigation.NavController
import com.example.project1.R
import com.example.project1.data.model.PostModel
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.logging.Filter

@Composable
fun Components(navController: NavController) {
    var component by remember { mutableStateOf("") }//actualizar el valor de la variable en la interfaz
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState, //current state of drawer
        // drawer content
        drawerContent = {
            ModalDrawerSheet {
                Text("Menu", modifier = Modifier.padding(16.dp))
                HorizontalDivider()
                //content 1
                NavigationDrawerItem(
                    label = { Text(text = "Content 1") },
                    selected = false,
                    onClick = {
                        component = "Content1"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                //content 2
                NavigationDrawerItem(
                    label = { Text(text = "Content 2") },
                    selected = false,
                    onClick = {
                        component = "Content2"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                //Buttons
                NavigationDrawerItem(
                    label = { Text(text = "Buttons") },
                    selected = false,
                    onClick = {
                        component = "Buttons"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                //Floating A Buttons
                NavigationDrawerItem(
                    label = { Text(text = "Floating Buttons") },
                    selected = false,
                    onClick = {
                        component = "floating-buttons"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                //Chips
                NavigationDrawerItem(
                    label = { Text(text = "Chips") },
                    selected = false,
                    onClick = {
                        component = "chips"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                //Progress
                NavigationDrawerItem(
                    label = { Text(text = "Progress") },
                    selected = false,
                    onClick = {
                        component = "progress"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                //Sliders
                NavigationDrawerItem(
                    label = { Text(text = "Sliders") },
                    selected = false,
                    onClick = {
                        component = "sliders"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                //Switches
                NavigationDrawerItem(
                    label = { Text(text = "Switches") },
                    selected = false,
                    onClick = {
                        component = "switches"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                //Badges
                NavigationDrawerItem(
                    label = { Text(text = "Badges") },
                    selected = false,
                    onClick = {
                        component = "badges"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                //DatePickers
                NavigationDrawerItem(
                    label = { Text(text = "DatePickers") },
                    selected = false,
                    onClick = {
                        component = "date-pickers"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                //TimePickers
                NavigationDrawerItem(
                    label = { Text(text = "TimePickers") },
                    selected = false,
                    onClick = {
                        component = "time-pickers"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                //SnackBars
                NavigationDrawerItem(
                    label = { Text(text = "SnackBars") },
                    selected = false,
                    onClick = {
                        component = "snack-bars"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                //AlertDialogs
                NavigationDrawerItem(
                    label = { Text(text = "AlertDialogs") },
                    selected = false,
                    onClick = {
                        component = "alert-dialogs"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                //Bars
                NavigationDrawerItem(
                    label = { Text(text = "Bars") },
                    selected = false,
                    onClick = {
                        component = "bars"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
            }
        }
    ) {
        //screen content
        Column {
            when (component) {
                "Content1" -> {
                    Content1()
                }
                "Content2" -> {
                    Content2()
                }
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
            }
        }
    }
}

@Composable
fun Content1() {
    Text(text = "Content 1")
}

@Composable
fun Content2() {
    Text(text = "Content 2")
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
            PostModel(1, "Title 1", "Text 1"),
            PostModel(2, "Title 2", "Text 2"),
            PostModel(3, "Title 3", "Text 3"),
            PostModel(4, "Title 4", "Text 4")
        )
        Column (
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(10.dp,90.dp,10.dp,50.dp)
                .fillMaxSize()
                //.verticalScroll(rememberScrollState())
        ){Posts(post)}
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
fun Posts(arrayPosts: Array<PostModel>){
    //Espera a que llegue la info para que se ejecute
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
    ) {//Se repetira este texto lo que queramos (creo xdd)
        items(arrayPosts) { post ->
            Text(
                text = post.title,
                color = Color.White,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(thickness = 2.dp)
        }
    }
}