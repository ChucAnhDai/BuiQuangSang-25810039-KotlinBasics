package com.example.sangcupcakes

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CupcakeNavigationApp()
        }
    }
}

@Composable
fun CupcakeNavigationApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "welcome"
    ) {
        composable("welcome") {
            WelcomeScreen(
                onStart = { navController.navigate("quantity") }
            )
        }
        composable("quantity") {
            QuantityScreen(
                onQuantitySelected = { quantity ->
                    navController.navigate("flavor/$quantity")
                }
            )
        }
        composable(
            route = "flavor/{quantity}",
            arguments = listOf(navArgument("quantity") { type = NavType.IntType })
        ) { entry ->
            val quantity = entry.arguments?.getInt("quantity") ?: 1
            FlavorScreen(
                quantity = quantity,
                onFlavorSelected = { flavor ->
                    navController.navigate("summary/$quantity/${Uri.encode(flavor)}")
                }
            )
        }
        composable(
            route = "summary/{quantity}/{flavor}",
            arguments = listOf(
                navArgument("quantity") { type = NavType.IntType },
                navArgument("flavor") { type = NavType.StringType }
            )
        ) { entry ->
            val quantity = entry.arguments?.getInt("quantity") ?: 1
            val flavor = entry.arguments?.getString("flavor").orEmpty()
            SummaryScreen(
                quantity = quantity,
                flavor = flavor,
                onOrderAgain = {
                    navController.navigate("welcome") {
                        popUpTo("welcome") { inclusive = true }
                    }
                }
            )
        }
    }
}

@Composable
fun WelcomeScreen(onStart: () -> Unit) {
    SimpleScreen {
        Text("SANG CUPCAKES", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Dat banh nho cho mot ngay vui", textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onStart) {
            Text("Bat dau")
        }
    }
}

@Composable
fun QuantityScreen(onQuantitySelected: (Int) -> Unit) {
    SimpleScreen {
        Text("Chon so luong", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(18.dp))
        listOf(2, 4, 6).forEach { quantity ->
            Button(
                onClick = { onQuantitySelected(quantity) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("$quantity cai banh")
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun FlavorScreen(quantity: Int, onFlavorSelected: (String) -> Unit) {
    SimpleScreen {
        Text("Chon huong vi cho $quantity cai", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(18.dp))
        Button(onClick = { onFlavorSelected("Dau") }, modifier = Modifier.fillMaxWidth()) {
            Text("Banh dau")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { onFlavorSelected("Socola") }, modifier = Modifier.fillMaxWidth()) {
            Text("Banh socola")
        }
    }
}

@Composable
fun SummaryScreen(quantity: Int, flavor: String, onOrderAgain: () -> Unit) {
    SimpleScreen {
        Text("Don hang cua ban", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))
        Text("$quantity cai banh $flavor")
        Text("Tong tien: ${quantity * 25000} VND")
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onOrderAgain) {
            Text("Dat don moi")
        }
    }
}

@Composable
private fun SimpleScreen(content: @Composable () -> Unit) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            content()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationPreview() {
    WelcomeScreen(onStart = {})
}
