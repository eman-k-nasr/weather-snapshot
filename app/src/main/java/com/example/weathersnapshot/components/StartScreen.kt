package com.example.weathersnapshot.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.actions.Actions
import com.example.weathersnapshot.R

@Composable
fun StartScreen(
    modifier: Modifier,
    getCurrentLocation: () -> Unit,
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        val context = LocalContext.current
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(16.dp)
        ){
            Image(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                painter = painterResource(id = R.drawable.snapshot),
                contentDescription = "map",
                contentScale = ContentScale.Inside,
            )
            Text(
                text = "Ready to Take beautiful snapshot!!",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
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
                    fontSize = 14.sp
                )
            )

            Text(
                text = "1- Know Weather status \n2- Take your beautiful snapshot!!"
            )
        }

        GetStartButton(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(Alignment.CenterHorizontally)
        ){
            context.startActivity(
                Actions.openWeatherActivity(context = context)
            )
        }
    }
}