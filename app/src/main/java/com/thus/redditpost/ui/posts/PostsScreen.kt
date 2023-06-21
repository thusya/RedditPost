package com.thus.redditpost.ui.posts

import android.webkit.URLUtil
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.thus.redditpost.R
import com.thus.redditpost.domain.model.PostsInfo
import com.thus.redditpost.ui.commoncomponents.PostImpactData
import com.thus.redditpost.ui.commonscreens.EmptyScreen
import com.thus.redditpost.ui.commonscreens.ErrorScreen
import com.thus.redditpost.ui.commonscreens.LoadingScreen
import com.thus.redditpost.ui.navigation.NavigationScreen
import com.thus.redditpost.ui.posts.components.PostContentRow
import com.thus.redditpost.ui.posts.components.PostOwnerDetailRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostsScreen(navController: NavController, viewModel: PostsViewModel) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.screen_name_posts),
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
            )
        }
    ) { paddingValues ->
        when (val state = viewModel.postsState.value) {
            is PostsState.Loading -> {
                LoadingScreen()
            }

            is PostsState.Empty -> {
                EmptyScreen()
            }

            is PostsState.Error -> {
                ErrorScreen {
                    viewModel.fetchPosts()
                }
            }

            is PostsState.Normal -> {
                PostsList(
                    paddingValues = paddingValues,
                    postInfoList = state.showInfoList
                ) { postInfo ->
                    viewModel.postDetailSelected = postInfo
                    navController.navigate(NavigationScreen.POSTS_DETAILS_SCREEN.name)
                }

            }
        }
    }
}

@Composable
fun PostsList(
    paddingValues: PaddingValues,
    postInfoList: List<PostsInfo>,
    onItemClick: (PostsInfo) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
    ) {
        items(postInfoList) { post ->
            PostsListItem(postInfo = post) {
                onItemClick(post)
            }
        }
    }
}

@Composable
fun PostsListItem(postInfo: PostsInfo, onItemClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(
                horizontal = 10.dp,
                vertical = 6.dp,
            )
            .fillMaxWidth()
    ) {

        val configuration = LocalConfiguration.current
        val screenSize = configuration.screenWidthDp.dp * 0.65f
        val columModifier = if (URLUtil.isValidUrl(postInfo.thumbnail)) {
            Modifier.width(screenSize)
        } else {
            Modifier.fillMaxWidth()
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 2.dp)
                .background(
                    MaterialTheme.colorScheme.onBackground.copy(
                        0.1f
                    )
                )
                .clickable(onClick = onItemClick)
        ) {
            // Row 1
            PostOwnerDetailRow(postInfo)

            // Row 2
            PostContentRow(columModifier, postInfo)

            //Row 3
            PostImpactData(postInfo)
        }

    }
}