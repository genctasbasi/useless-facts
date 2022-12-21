package com.escmobile.uselessfacts.ui.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.escmobile.uselessfacts.ui.viewmodels.UselessFactViewModel

@Composable
fun DisplayFact(uselessFactViewModel: UselessFactViewModel) {

    val factState by uselessFactViewModel.factObservable.observeAsState()

    factState?.text?.let { fact ->
        Text(
            modifier = Modifier
                .padding(20.dp),
            text = fact
        )
    }
}