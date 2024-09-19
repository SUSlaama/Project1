package com.example.project1

import android.graphics.Picture
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import com.example.project1.ui.theme.Project1Theme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.project1.ui.sreens.HomeScreen
import com.example.project1.ui.sreens.MenuScreen

//import androidx.navigation.compose.NavHostController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            //ComposeMultiScreenApp()
            screen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun screen() {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = Color.Black,
                contentColor = Color.White
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {//.clickable(onClick = { clickAction()})
                    IconButton(onClick = { clickAction() }) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Home",
                            tint = Color.White
                        )
                    }
                    IconButton(onClick = { clickAction() }) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Friends",
                            tint = Color.White
                        )
                    }
                    IconButton(onClick = { clickAction() }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",
                            tint = Color.White
                        )
                    }
                    IconButton(onClick = { clickAction() }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Library",
                            tint = Color.White
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(innerPadding)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.xbox_logo),
                    contentDescription = "Xbox logo",
                    modifier = Modifier.size(40.dp)
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(3.dp)
                ) {
                    IconButton(
                        onClick = { clickAction() },
                        modifier = Modifier
                            .size(40.dp)
                            .background(Color.Gray, CircleShape)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Perfil",
                            tint = Color.White,
                            modifier = Modifier
                                .size(35.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    IconButton(
                        onClick = { clickAction() },
                        modifier = Modifier
                            .size(40.dp)
                            .background(Color.Gray, CircleShape)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "Notifications",
                            tint = Color.White,
                            modifier = Modifier
                                .size(32.dp)
                        )
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                repeat(3) {
                    Column(
                        modifier = Modifier
                            .background(Color.Gray)
                            .clickable { clickAction() },
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.avatar_placeholder),
                            contentDescription = "Friend Avatar",
                            modifier = Modifier
                                .size(90.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "VegetaGamer$it",
                            color = Color.White,
                            fontSize = 15.sp
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Call of duty $it",
                            color = Color.White,
                            fontSize = 15.sp
                        )
                    }
                }
            }
            Text(
                text = "Vuelve al juego 2",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.game1),
                    contentDescription = "Game cover",
                    modifier = Modifier
                        .size(100.dp)
                        .clickable { clickAction() }
                )
                Image(
                    painter = painterResource(id = R.drawable.game2),
                    contentDescription = "Game cover",
                    modifier = Modifier
                        .size(100.dp)
                        .clickable { clickAction() }
                )
                Image(
                    painter = painterResource(id = R.drawable.game3),
                    contentDescription = "Game cover",
                    modifier = Modifier
                        .size(100.dp)
                        .clickable { clickAction() }
                )
            }
            Text(
                text = "Popular entre amigos",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.game3),
                    contentDescription = "Game cover",
                    modifier = Modifier
                        .size(100.dp)
                        .clickable { clickAction() }
                )
                Image(
                    painter = painterResource(id = R.drawable.game1),
                    contentDescription = "Game cover",
                    modifier = Modifier
                        .size(100.dp)
                        .clickable { clickAction() }
                )
                Image(
                    painter = painterResource(id = R.drawable.game2),
                    contentDescription = "Game cover",
                    modifier = Modifier
                        .size(100.dp)
                        .clickable { clickAction() }
                )
            }
            Text(
                text = "Recomendación desde Game Pass",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                repeat(3) {
                    Image(
                        painter = painterResource(id = R.drawable.game4),
                        contentDescription = "Juegos de game pass",
                        modifier = Modifier
                            .size(100.dp)
                            .clickable { clickAction() }
                    )
                }
            }

        }
    }

}
/*Column(
    //LA columna pasa a tener el tamaño maximo de la pantalla
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
){
    CustomText()
    Picture()
    Content1()
    Content2()
    //Text(text = "Simple text")
    //ModifierExample()
    //ModifierExample2()
    //ModifierExample3()
}
//Layout
/*Column {
   Text(text= "First Row")
    Text(text= "Second Row")
    Text(text= "Third Row")
    Row {
        Text(text= "Among OS")
        Text(text= " Among OS 2")
        Text(text= " Among OS 3: The revenge")
        Text(text= " Among OS 4: The end game")
    }
    Box {
        Text(text= "Label 1")
        Text(text= "Label 2")
    }
    Greeting(name = "World")
}
Column {
    Row {
        Text(text= "Among OS")
    }
}*/
/*Project1Theme {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Greeting(
            name = "Android",
            modifier = Modifier.padding(innerPadding)
        )
    }
}*/
}
}
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
Text(
text = "Hello $name!",
modifier = modifier
)
}

//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
Project1Theme {
Greeting("Uriel")
}
}

//@Preview(showBackground = true)
@Composable
fun ModifierExample(){
Column(
modifier = Modifier
.padding(24.dp)
) {
Text(text = "Hello world")
}
}

//@Preview(showBackground = true)
/*@Composable //Comopasble es de diseño solamente
fun ModifierExample2(){
Column(
modifier = Modifier
.padding(24.dp)
.fillMaxWidth()
.clickable(onClick = { clickAction()})
) {
Text(text = "Hello world")
}
}*/

@Preview(showBackground = true)
@Composable //Comopasble es de diseño solamente
fun ModifierExample3(){
Column(
modifier = Modifier
.fillMaxHeight()
.padding(16.dp)
.background(Color.Magenta)
.border(width = 2.dp, color = Color.Blue)
.width(200.dp),
horizontalAlignment = Alignment.CenterHorizontally,
verticalArrangement = Arrangement.SpaceEvenly
) {
Text(text = "Item 1")
Text(text = "Item 2")
Text(text = "Item 3")
Text(text = "Item 4")
Text(text = "Item 5")
}
}

@Preview(showBackground = true)
@Composable
fun CustomText(){
Column {
Text(
stringResource(R.string.hello_world_text),
color = colorResource(R.color.teal_700),
fontSize = 28.sp,
fontStyle = FontStyle.Italic,
fontWeight = FontWeight.Thin
)
val gradientColors = listOf(Cyan,Blue)
Text(
stringResource(R.string.hello_world_text),
style = TextStyle(brush = Brush.linearGradient(colors = gradientColors))
)
}
}

//@Preview(showBackground = true)
@Composable
fun Picture(){
Column (
modifier = Modifier
.fillMaxHeight()
.background(Color.Black)
) {
Image(
modifier = Modifier
    .fillMaxWidth(),
painter = painterResource(R.drawable.android_logo),
contentDescription = "Android logo",
contentScale = ContentScale.Crop
)
}
}

//@Preview(showBackground = true)
@Composable
fun Content1(){
Card(modifier = Modifier
.background(Color.LightGray)
.fillMaxWidth()
.padding(5.dp)
){
Text(text = "This is a title",
fontSize = 24.sp,
fontWeight = FontWeight.Bold,
modifier = Modifier
    .padding(10.dp)
)
Image(
modifier = Modifier
    .fillMaxWidth()
    .height(200.dp),
painter = painterResource(id = R.drawable.android_logo),
contentDescription = "Android Logo",
contentScale = ContentScale.Crop
)
Text(
stringResource(R.string.text_card),
textAlign = TextAlign.Justify,
lineHeight = 10.sp,
modifier = Modifier
    .padding(10.dp)
)
}
}

@Preview(showBackground = true)
@Composable
fun Content2(){
Card(modifier = Modifier
.background(Color.LightGray)
.fillMaxWidth()
.padding(5.dp)) {

Column {

Row {
    Image(modifier = Modifier
        //.fillMaxWidth()
        .height(150.dp),
        painter = painterResource(id = R.drawable.android_logo),
        contentDescription = "Android Logo",
        contentScale = ContentScale.Crop)
    Column {
        Text(text = "This is a title",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
        )
        Text(stringResource(R.string.text_card),
            textAlign = TextAlign.Justify,
            lineHeight = 10.sp,
            modifier = Modifier
                .padding(10.dp))
    }
}
}
}
}

@Preview(showBackground = true)
@Composable
fun BoxExample1() {
Box(
modifier = Modifier
.background(Color.DarkGray)
.fillMaxWidth()
.padding(5.dp)
){
Image(painterResource(R.drawable.android_logo),
contentDescription = "Android Logo",
contentScale = ContentScale.FillBounds
)
Row(
modifier = Modifier
    .fillMaxWidth()
    .padding(0.dp, 150.dp),
horizontalArrangement = Arrangement.Center
){
Icon(
    Icons.Filled.AccountCircle,
    contentDescription = "Icon Account"
)
Text(text = "Text",

)
}

}
}

@Preview(showBackground = true)
@Composable
fun BoxExample2(){
Box(modifier = Modifier
.background(Color.Magenta)
.padding(5.dp)
.size(250.dp)
){
Text(text = "TopStart", Modifier.align(Alignment.TopStart))
Text(text = "TopEnd", Modifier.align(Alignment.TopEnd))
Text(text = "CenterStart", Modifier.align(Alignment.CenterStart))
Text(text = "Center", Modifier.align(Alignment.Center))
Text(text = "CenterEnd", Modifier.align(Alignment.CenterEnd))
Text(text = "BottomStart", Modifier.align(Alignment.BottomStart))
Text(text = "BottomEnd", Modifier.align(Alignment.BottomEnd))
}
}
*/
fun clickAction(){
println("Column clicked")
}
/*
@Composable
fun ComposeMultiScreenApp(){
    val navController = rememberNavController()
    Surface(color = Color.White) {
        SetupNavGraph(navController = navController)
    }
}

@Composable
fun SetupNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = "menu"){
        composable("menu") { MenuScreen(navController) }
        composable("home") { HomeScreen(navController) }
    }
}*/