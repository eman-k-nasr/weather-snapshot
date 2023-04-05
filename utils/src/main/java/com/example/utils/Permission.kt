package com.example.utils
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.google.accompanist.permissions.*

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun Permission(
    permission: String,
    rationale: String = "This permission is important for this app. Please grant the permission.",
    content: @Composable () -> Unit = { }
) {
    val permissionState = rememberPermissionState(permission)
    if(permissionState.status.isGranted){
        content.invoke()
    }else{
        Rationale(
            text = rationale,
            onRequestPermission = { permissionState.launchPermissionRequest() }
        )
    }
}

@Composable
private fun Rationale(
    text: String,
    onRequestPermission: () -> Unit
) {
    AlertDialog(
        onDismissRequest = {},
        title = {
            Text(text = "Permission request")
        },
        text = {
            Text(text)
        },
        confirmButton = {
            Button(onClick = onRequestPermission) {
                Text("Got it..")
            }
        }
    )
}