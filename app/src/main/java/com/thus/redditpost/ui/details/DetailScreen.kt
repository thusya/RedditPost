package com.thus.redditpost.ui.details

import android.webkit.URLUtil
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.thus.redditpost.R
import com.thus.redditpost.ui.commoncomponents.PostImpactData
import com.thus.redditpost.ui.details.component.PostDetailBody
import com.thus.redditpost.ui.details.component.PostDetailHeader
import com.thus.redditpost.ui.details.component.PostDetailTitle
import com.thus.redditpost.ui.posts.PostsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavController, viewModel: PostsViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.screen_name_post_detail),
                        style = MaterialTheme.typography.titleMedium
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(Icons.Filled.ArrowBack, "back icon")
                    }
                }
            )
        }
    ) { paddingValue ->
        viewModel.postDetailSelected?.let { postsInfo ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(paddingValue)
                    .background(MaterialTheme.colorScheme.onBackground.copy(0.1f))
            ) {
                PostDetailHeader(postsInfo)
                PostDetailTitle(postsInfo)
                if (URLUtil.isValidUrl(postsInfo.thumbnail)) {
                    PostDetailBody(postsInfo)
                }
                PostImpactData(postsInfo)
            }
        }
    }
}