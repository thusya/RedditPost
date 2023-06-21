package com.thus.redditpost.ui.commoncomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.thus.redditpost.R
import com.thus.redditpost.domain.model.PostsInfo
import com.thus.redditpost.ui.util.Utils

@Composable
fun PostImpactData(
    postsInfo: PostsInfo
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp, horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row {
            Image(
                imageVector = Icons.Default.KeyboardArrowUp,
                contentDescription = "Up Votes",
                contentScale = ContentScale.Inside,
            )
            Spacer(modifier = Modifier.width(2.dp))
            Text(
                text = Utils.formatCount(postsInfo.ups),
                style = TextStyle(
                    color = Color.Gray
                )
            )
            Spacer(modifier = Modifier.width(2.dp))
            Image(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "Down Votes",
                contentScale = ContentScale.Inside,
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Row {
            Image(
                painterResource(R.drawable.baseline_comment_24),
                contentDescription = "Comments",
                contentScale = ContentScale.Inside,
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = Utils.formatCount(postsInfo.numComments),
                style = TextStyle(
                    color = Color.Gray
                )
            )
        }
    }
}