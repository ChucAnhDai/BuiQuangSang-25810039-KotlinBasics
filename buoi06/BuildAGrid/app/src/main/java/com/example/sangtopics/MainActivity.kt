package com.example.sangtopics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class Topic(
    val name: String,
    val lessons: Int,
    val symbol: String
)

private val topics = listOf(
    Topic("Kotlin", 12, "K"),
    Topic("Compose", 9, "C"),
    Topic("Giao dien", 7, "G"),
    Topic("Navigation", 5, "N"),
    Topic("Du lieu", 6, "D"),
    Topic("Kiem thu", 4, "T")
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopicGridApp()
        }
    }
}

@Composable
fun TopicGridApp() {
    Surface(modifier = Modifier.fillMaxSize()) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(topics, key = { it.name }) { topic ->
                TopicCard(topic)
            }
        }
    }
}

@Composable
fun TopicCard(topic: Topic) {
    Card {
        androidx.compose.foundation.layout.Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = topic.symbol,
                style = MaterialTheme.typography.displaySmall,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = topic.name,
                style = MaterialTheme.typography.titleMedium
            )
            Text(text = "${topic.lessons} bai hoc")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopicGridPreview() {
    TopicGridApp()
}
