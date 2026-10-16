package com.example.sangcolors.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sangcolors.data.ColorItem
import com.example.sangcolors.data.ColorViewModel

@Composable
fun ColorScreen(colorViewModel: ColorViewModel = viewModel()) {
    val colors by colorViewModel.colors.collectAsState()
    var name by rememberSaveable { mutableStateOf("") }
    var hex by rememberSaveable { mutableStateOf("#") }
    var message by rememberSaveable { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text(
                    text = "COLOR VALUE",
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = "Danh sách màu được lưu bằng Room và cập nhật bằng Flow."
                )
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Tên màu") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = hex,
                    onValueChange = { hex = it },
                    label = { Text("Mã màu, ví dụ #4D96FF") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
                Button(
                    onClick = {
                        if (name.isBlank() || !isHexColor(hex)) {
                            message = "Nhập tên và mã màu dạng #RRGGBB"
                        } else {
                            colorViewModel.addColor(name, hex)
                            name = ""
                            hex = "#"
                            message = ""
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Lưu màu")
                }
                if (message.isNotEmpty()) {
                    Text(
                        text = message,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        }

        if (colors.isEmpty()) {
            item {
                Text("Chưa có màu nào.")
            }
        }

        items(colors, key = { it.id }) { color ->
            ColorRow(color = color, onDelete = { colorViewModel.deleteColor(color) })
        }

        item {
            Text(
                text = "Đóng và mở lại app để kiểm tra dữ liệu vẫn còn trong database.",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
private fun ColorRow(color: ColorItem, onDelete: () -> Unit) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(toComposeColor(color.hex))
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 12.dp)
            ) {
                Text(color.name, style = MaterialTheme.typography.titleMedium)
                Text(color.hex, style = MaterialTheme.typography.bodyMedium)
            }
            IconButton(onClick = onDelete) {
                Text("X")
            }
        }
    }
}

private fun isHexColor(value: String): Boolean {
    return Regex("#[0-9a-fA-F]{6}").matches(value.trim())
}

private fun toComposeColor(value: String): Color {
    return try {
        Color(android.graphics.Color.parseColor(value))
    } catch (_: IllegalArgumentException) {
        Color.LightGray
    }
}
