package com.example.project1

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.project1.clases.BiometricPromptManager
import com.example.project1.ui.sreens.Components
import com.example.project1.ui.sreens.HomeScreen
import com.example.project1.ui.sreens.LoginScreen
import com.example.project1.ui.sreens.MenuScreen
import com.example.project1.ui.sreens.ProfileScreen
import com.example.project1.ui.theme.Project1Theme

class MainActivity : AppCompatActivity() {

    private  val promptManager  by lazy{
        BiometricPromptManager(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Project1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        ComposeMultiScreenApp(promptManager)
                    }
                }
            }
            //ComposeMultiScreenApp()
        }
    }
}

@Composable
fun ComposeMultiScreenApp(promptManager: BiometricPromptManager) {
    val navController = rememberNavController()
    Surface(color = Color.White) {
        SetupNavGraph(navController = navController, promptManager)
    }
}
//Prueba

@Composable
fun SetupNavGraph(navController: NavHostController, promptManager: BiometricPromptManager){
    NavHost(navController = navController, startDestination = "login"){
        composable("menu") { MenuScreen(navController) }
        composable("home") { HomeScreen(navController) }
        composable("componentes") { Components(navController, promptManager)}
        composable("login") { LoginScreen(navController)}
        composable("profile") { ProfileScreen(navController)}
    }
}