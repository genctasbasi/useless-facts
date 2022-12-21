package com.escmobile.uselessfacts.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.escmobile.uselessfacts.ui.composable.DisplayFact
import com.escmobile.uselessfacts.ui.composable.DisplayStats
import com.escmobile.uselessfacts.ui.composable.GetFact
import com.escmobile.uselessfacts.ui.theme.UselessFactsTheme
import com.escmobile.uselessfacts.ui.viewmodels.UselessFactViewModel
import com.escmobile.uselessfacts.util.Util.Companion.TAG
import org.koin.android.ext.android.inject

class ComposeActivity : ComponentActivity() {

    private val factViewModel: UselessFactViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setViewModel()

        setContent {
            UselessFactsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Init(factViewModel)
                }
            }
        }
    }

    private fun setViewModel() {
        // fact change is also observed by the Activity, as well as the DisplayFact composable
        factViewModel.factObservable.observe(this){ fact ->
            Log.d(TAG, "Fact observed by the Activity: $fact")
        }
    }
}

@Composable
fun Init(factViewModel: UselessFactViewModel) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(Color.LightGray)

    ) {
        GetFact { factViewModel.onGetFactButtonClick() }
        DisplayFact(factViewModel)

        Text(
            modifier = Modifier
                .padding(20.dp),
            text = "Stats"
        )

        DisplayStats(factViewModel)
    }
}