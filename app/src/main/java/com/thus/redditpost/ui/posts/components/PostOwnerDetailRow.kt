package com.thus.redditpost.ui.posts.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.thus.redditpost.domain.model.PostsInfo
import com.thus.redditpost.ui.commoncomponents.AuthorWithPostedHour

@Composable
fun PostOwnerDetailRow(postsInfo: PostsInfo) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AuthorWithPostedHour(postsInfo)

        Image(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "More Options",
            contentScale = ContentScale.Inside,
        )
    }
}
