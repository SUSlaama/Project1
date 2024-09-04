package com.example.project1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.project1.ui.theme.Project1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            //Layout
            Column {
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
            }
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Project1Theme {
        Greeting("Uriel")
    }
}