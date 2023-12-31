package com.thus.redditpost.ui.details.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.thus.redditpost.domain.model.PostsInfo
import com.thus.redditpost.ui.commoncomponents.CustomTitleWithChip

@Composable
fun PostDetailTitle(postsInfo: PostsInfo) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CustomTitleWithChip(
            modifier = Modifier.fillMaxWidth(),
            postsInfo
        )
    }
}