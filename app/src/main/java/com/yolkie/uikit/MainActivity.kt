package com.yolkie.uikit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.yolkie.uikit.ui.theme.UIKitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UIKitTheme {
                MainApp()
            }
        }
    }
}

@Composable
fun MainAppBar(
    currentScreen: Screen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainApp(
    navController: NavHostController = rememberNavController()
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = Screen.valueOf(
        backStackEntry?.destination?.route ?: Screen.MAIN.name
    )

    NavHost(
        navController = navController,
        startDestination = Screen.MAIN.name,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(Screen.MAIN.name) {
            MainScreen(
                onButtonClicked = {
                    navController.navigate(it.name)
                },
                modifier = Modifier.fillMaxSize()
            )
        }
        composable(Screen.YELP_DETAIL.name) {
            YelpDetailScreen(
                modifier = Modifier.fillMaxSize(),
                onBackClicked = {
                    navController.popBackStack()
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    onButtonClicked: (Screen) -> Unit,
    modifier: Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "UI Playground")
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            FilledTonalButton(
                onClick = {
                    onButtonClicked(Screen.YELP_DETAIL)
                }
            ) {
                Text(text = "Yelp Detail Screen")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainPreview() {
    UIKitTheme {
        MainApp()
    }
}