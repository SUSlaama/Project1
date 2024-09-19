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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
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
                .verticalScroll(rememberScrollState())
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
                    ) {Box(
                        modifier = Modifier.size(95.dp),
                        contentAlignment = Alignment.BottomEnd
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.avatar_placeholder),
                            contentDescription = "Friend Avatar",
                            modifier = Modifier
                                .size(95.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                        Box(
                            modifier = Modifier
                                .size(16.dp)
                                .clip(CircleShape)
                                .background(Color.Green)
                        )
                    }
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
                text = "Vuelve al juego",
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

fun clickAction(){
println("Click works")
}
