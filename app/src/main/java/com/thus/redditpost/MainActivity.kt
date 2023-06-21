package com.thus.redditpost

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.thus.redditpost.ui.details.DetailScreen
import com.thus.redditpost.ui.navigation.NavigationScreen
import com.thus.redditpost.ui.posts.PostsScreen
import com.thus.redditpost.ui.posts.PostsViewModel
import com.thus.redditpost.ui.theme.RedditPostTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel: PostsViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RedditPostTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = NavigationScreen.POSTS_SCREEN.name
                    ) {
                        composable(NavigationScreen.POSTS_SCREEN.name) {
                            PostsScreen(navController, viewModel)
                        }
                        composable(NavigationScreen.POSTS_DETAILS_SCREEN.name) {
                            DetailScreen(navController, viewModel)
                        }
                    }
                }
            }
        }
    }
}