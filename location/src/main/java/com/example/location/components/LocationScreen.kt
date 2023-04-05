package com.example.location.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.location.R

@Composable
fun LocationScreen(
    modifier: Modifier,
    getCurrentLocation: () -> Unit,
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
                painter = painterResource(id = R.drawable.map ),
                contentDescription = "map",
                contentScale = ContentScale.Inside,
            )
            Text(
                text = "Ready to Take beautiful snapshot!!",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )
            )
            Text(
                text = "We provide you a way to take beautiful photos with overlay text that contains weather status depending on where you are .."
            )
            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = "To get your beautiful photo ,we'll go through these small steps: ",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            )

            Text(
                text = "1- Get Access To your Location \n2- Get Weather status \n3- Take your beautiful snapshot!!"
            )
            if(shouldShowPermission){
                LocationPermission{
                    getCurrentLocation.invoke()

                }
            }
        }

        GetLocationButton(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(Alignment.CenterHorizontally)
        ){
            shouldShowPermission = true
        }

    }
}
