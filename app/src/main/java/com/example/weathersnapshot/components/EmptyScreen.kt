package com.example.weathersnapshot.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.utils.IconTextButton
import com.example.weathersnapshot.R

@Composable
fun EmptyScreen(
    onClick: () -> Unit,
){
    Column(modifier = Modifier.padding(16.dp)) {
        Image(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.empty),
            contentDescription = "empty",
            contentScale = ContentScale.Inside,
        )
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(16.dp),
            text = "You have no history , click button blow to add a new snapshot!!",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        )

        IconTextButton(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(Alignment.CenterHorizontally),
            text = "Get Started",
            icon = Icons.Outlined.ThumbUp
        ) {
            onClick.invoke()
        }
    }
}