package com.example.weather.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.utils.IconTextButton
import com.example.weather.R

@Composable
fun WeatherScreen(
    modifier: Modifier,
    getCurrentLocation: () -> Unit
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        var shouldShowPermission by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(16.dp)
        ){
            Image(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                painter = painterResource(id = R.drawable.weather),
                contentDescription = "map",
                contentScale = ContentScale.Inside,
            )
            Text(
                text = "Here you are !! \nReady to know weather today..",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )
            )

            if(shouldShowPermission){
                LocationPermission{
                    getCurrentLocation.invoke()
                }
            }

        }

        IconTextButton(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(Alignment.CenterHorizontally),
            text = "Know Weather",
            icon =  Icons.Filled.Cloud
        ) {
            shouldShowPermission = true
        }
    }

}