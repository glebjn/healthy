package com.i.healthy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.i.auth_impl.AuthScreen
import com.i.healthy.ui.theme.HealthyTheme
import com.i.records_impl.RecordScreen
import com.i.records_impl.RecordsListScreen

private const val LOGIN_SCREEN_ROUTE = "login_route"
private const val RECORDS_LIST_SCREEN_ROUTE = "records_list_route"
private const val RECORD_SCREEN_ROUTE = "record_route"

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HealthyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController: NavHostController = rememberNavController()
                    NavHost(
                        modifier = Modifier,
                        navController = navController,
                        startDestination = LOGIN_SCREEN_ROUTE
                    ) {
                        composable(LOGIN_SCREEN_ROUTE) {
                            AuthScreen {
                                navController.navigate(RECORDS_LIST_SCREEN_ROUTE)
                            }
                        }
                        composable(RECORDS_LIST_SCREEN_ROUTE) {
                            RecordsListScreen { id ->
                                navController.navigate(RECORD_SCREEN_ROUTE)
                            }
                        }
                        composable(RECORD_SCREEN_ROUTE) {
                            RecordScreen()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Hello $name!",
            modifier = modifier,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HealthyTheme {
        Greeting("Android")
    }
}