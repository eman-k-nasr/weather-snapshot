package com.example.utils

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SnapshotTopbar(modifier: Modifier = Modifier){
    TopBar(modifier = modifier, title = "Snapshot", backIcon = null)
}

@Composable
fun TopBar(
    modifier: Modifier,
    title: String,
    backIcon: @Composable (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
){
    TopAppBar(
        modifier = modifier.height(60.dp),
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Start,
                fontSize = 16.sp
            )
        },
        navigationIcon = backIcon,
        backgroundColor = Color.White,
        actions = actions
    )
}

@Composable
fun BackIcon(
    onBackClicked: () -> Unit
){
    IconButton(
        modifier = Modifier.semantics { contentDescription = "backBtn" },
        onClick = { onBackClicked.invoke() }
    ) {
        Icon(
            imageVector = Icons.Default.ArrowForward,
            contentDescription = "Go back"
        )
    }
}