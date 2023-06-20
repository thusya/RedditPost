package com.thus.redditpost

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.thus.redditpost.ui.commonscreens.EmptyScreen
import com.thus.redditpost.ui.commonscreens.ErrorScreen
import com.thus.redditpost.ui.commonscreens.LoadingScreen
import com.thus.redditpost.ui.posts.PostsState
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
                    Greeting("Android")

                    when (val state = viewModel.postsState.value) {
                        is PostsState.Loading -> {
                            LoadingScreen()
                        }

                        is PostsState.Empty -> {
                            EmptyScreen()
                        }

                        is PostsState.Normal -> {
                            val response = state.showInfoList

                            Log.d("test ", response.toString())
                        }

                        is PostsState.Error -> {
                            ErrorScreen {
                                viewModel.fetchPosts()
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RedditPostTheme {
        Greeting("Android")
    }
}