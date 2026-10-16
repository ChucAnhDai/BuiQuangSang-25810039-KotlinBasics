package com.example.sangscore.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ScoreScreen(scoreViewModel: ScoreViewModel = viewModel()) {
    val uiState by scoreViewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "SCORE KEEPER",
            style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text = "Bảng điểm đơn giản dùng ViewModel và StateFlow",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ScoreCard(
                teamName = "Đội Xanh",
                score = uiState.blueScore,
                onAddPoint = { scoreViewModel.addPoints(true, it) },
                modifier = Modifier.weight(1f)
            )
            ScoreCard(
                teamName = "Đội Cam",
                score = uiState.orangeScore,
                onAddPoint = { scoreViewModel.addPoints(false, it) },
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedButton(
            onClick = { scoreViewModel.resetScore() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Đặt lại điểm")
        }

        Text(
            text = "Trạng thái được giữ lại khi màn hình được tạo lại.",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun ScoreCard(
    teamName: String,
    score: Int,
    onAddPoint: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(teamName, style = MaterialTheme.typography.titleMedium)
            Text(score.toString(), style = MaterialTheme.typography.displaySmall)
            Button(onClick = { onAddPoint(1) }, modifier = Modifier.fillMaxWidth()) {
                Text("+1")
            }
            Button(onClick = { onAddPoint(2) }, modifier = Modifier.fillMaxWidth()) {
                Text("+2")
            }
        }
    }
}
