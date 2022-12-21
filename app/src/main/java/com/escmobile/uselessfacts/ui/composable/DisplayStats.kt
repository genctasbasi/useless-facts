package com.escmobile.uselessfacts.ui.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.escmobile.uselessfacts.data.Fact
import com.escmobile.uselessfacts.ui.viewmodels.UselessFactViewModel

@Composable
fun DisplayStats(uselessFactViewModel: UselessFactViewModel) {

    val factState by uselessFactViewModel.factObservable.observeAsState()

    factState?.let { fact ->
        Text(
            modifier = Modifier
                .padding(10.dp),
            text = buildStats(fact)
        )
    }
}

fun buildStats(fact: Fact) = "language: " + fact.language + ", permalink: " + fact.permalink

