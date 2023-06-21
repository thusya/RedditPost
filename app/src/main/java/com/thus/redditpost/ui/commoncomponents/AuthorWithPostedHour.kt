package com.thus.redditpost.ui.commoncomponents

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.thus.redditpost.domain.model.PostsInfo

@Composable
fun AuthorWithPostedHour(postsInfo: PostsInfo) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "u/${postsInfo.author}",
            style = TextStyle(
                color = Color.Gray
            )
        )

        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = postsInfo.created.toString(),
            style = TextStyle(
                color = Color.Gray
            ),
        )
    }
}