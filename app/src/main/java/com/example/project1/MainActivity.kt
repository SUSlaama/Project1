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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project1.ui.theme.Project1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            Column(
                //LA columna pasa a tener el tamaño maximo de la pantalla
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
            ){
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
@Composable //Comopasble es de diseño solamente
fun ModifierExample2(){
    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()
            .clickable(onClick = { clickAction()})
    ) {
        Text(text = "Hello world")
    }
}

//@Preview(showBackground = true)
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

@Preview(showBackground = true)
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

fun clickAction(){
    println("Column clicked")
}