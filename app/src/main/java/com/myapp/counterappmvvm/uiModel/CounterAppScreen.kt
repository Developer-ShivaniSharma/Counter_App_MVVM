package com.myapp.counterappmvvm.uiModel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CounterScreen(
    modifier: Modifier = Modifier,
    counterAppViewModel: CounterAppViewModel = viewModel()
) {
    // state variable for collecting the emitted counterValue.
    val counterValue by counterAppViewModel.uiState.collectAsState()

    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = counterValue.toString(),
            style = MaterialTheme.typography.headlineSmall
        )
        Row {
            Button(onClick = { counterAppViewModel.increment() }) {
                Text(text = "+")
            }
            Spacer(modifier = Modifier.width(5.dp))
            Button(onClick = { counterAppViewModel.decrement() }) {
                Text(text = "-")

            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun CounterScreenPreview() {
    CounterScreen()
}