package com.escmobile.uselessfacts.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun GetFact(onGetFactButtonClick : () -> Unit) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .background(Color.LightGray)

    ) {
        Button(
            modifier = Modifier
                .width(200.dp)
                .height(50.dp),
            onClick = onGetFactButtonClick) {
            Text(text = "Get my fact")
        }
    }
}