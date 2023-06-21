package com.thus.redditpost.ui.posts.components

import android.webkit.URLUtil
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.thus.redditpost.domain.model.PostsInfo
import com.thus.redditpost.ui.commoncomponents.CustomTitleWithChip
import com.thus.redditpost.ui.util.WebUtil


@Composable
fun PostContentRow(
    modifier: Modifier,
    postsInfo: PostsInfo,
    webUtil: WebUtil
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        CustomTitleWithChip(modifier, postsInfo)
        if (URLUtil.isValidUrl(postsInfo.thumbnail)) {
            CustomImageContainer(postsInfo, webUtil)
        }
    }
}