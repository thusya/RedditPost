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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import com.thus.redditpost.R
import com.thus.redditpost.domain.model.PostsInfo
import com.thus.redditpost.ui.commoncomponents.PostImpactData
import com.thus.redditpost.ui.commonscreens.EmptyScreen
import com.thus.redditpost.ui.commonscreens.ErrorScreen
import com.thus.redditpost.ui.commonscreens.LoadingScreen
import com.thus.redditpost.ui.navigation.NavigationScreen
import com.thus.redditpost.ui.posts.components.PostContentRow
import com.thus.redditpost.ui.posts.components.PostOwnerDetailRow
import com.thus.redditpost.ui.util.WebUtil

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostsScreen(
    navController: NavController,
    viewModel: PostsViewModel,
    webUtil: WebUtil
) {

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
        PostsList(
            paddingValues = paddingValues,
            lazyPagingItems = viewModel.posts.collectAsLazyPagingItems(),
            webUtil = webUtil
        ) { postInfo ->
            viewModel.postDetailSelected = postInfo
            navController.navigate(NavigationScreen.POSTS_DETAILS_SCREEN.name)
        }
    }
}

@Composable
fun PostsList(
    paddingValues: PaddingValues,
    lazyPagingItems: LazyPagingItems<PostsInfo>,
    webUtil: WebUtil,
    onItemClick: (PostsInfo) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
    ) {
        when (val loadState = lazyPagingItems.loadState.refresh) {
            is LoadState.Loading -> {
                item {
                    LoadingScreen()
                }
            }

            is LoadState.Error -> {
                val error = loadState.error
                item {
                    ErrorScreen(error) {
                        lazyPagingItems.retry()
                    }
                }
            }

            else -> {}
        }

        items(
            count = lazyPagingItems.itemCount,
            key = lazyPagingItems.itemKey { it.id },
            contentType = lazyPagingItems.itemContentType { "contentType" }
        ) { index ->
            val post = lazyPagingItems[index]
            if (post != null) {
                PostsListItem(postInfo = post, webUtil = webUtil) {
                    onItemClick(post)
                }
            } else {
                PostsListItem(postInfo = PostsInfo(), webUtil = webUtil) { // Make placeholder here
                }
            }

        }
        lazyPagingItems.itemKey() { it.after }

        when {
            lazyPagingItems.loadState.refresh is LoadState.NotLoading &&
                    lazyPagingItems.itemCount == 0 -> {
                item {
                    EmptyScreen()
                }
            }

            lazyPagingItems.loadState.append is LoadState.Loading -> {
                item {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.CenterHorizontally)
                    )
                }
            }

            lazyPagingItems.loadState.append is LoadState.Error -> {
                (lazyPagingItems.loadState.append as? LoadState.Error)?.error?.let { error ->
                    item {
                        ErrorScreen(error) {
                            lazyPagingItems.retry()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PostsListItem(postInfo: PostsInfo, webUtil: WebUtil, onItemClick: () -> Unit) {
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
            PostContentRow(columModifier, postInfo, webUtil)

            //Row 3
            PostImpactData(postInfo)
        }

    }
}