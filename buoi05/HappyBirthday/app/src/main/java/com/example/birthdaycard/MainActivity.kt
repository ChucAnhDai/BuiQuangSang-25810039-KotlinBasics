package com.example.birthdaycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirthdayCardApp()
        }
    }
}

@Composable
fun BirthdayCardApp() {
    var daGuiLoiChuc by rememberSaveable { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFFFF1F5)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_gift),
                contentDescription = "Hop qua sinh nhat",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "HAPPY BIRTHDAY",
                style = MaterialTheme.typography.headlineLarge,
                color = Color(0xFFB3265E)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Minh Anh",
                fontSize = 34.sp,
                color = Color(0xFF7A1FA2)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Chuc ban luon vui ve va co mot ngay sinh nhat that dang nho!",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(28.dp))
            Button(onClick = { daGuiLoiChuc = true }) {
                Text(if (daGuiLoiChuc) "Da gui loi chuc" else "Gui loi chuc")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    BirthdayCardApp()
}
