package com.thus.redditpost.ui.commoncomponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontSynthesis
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thus.redditpost.domain.model.PostsInfo

@Composable
fun CustomTitleWithChip(
    modifier: Modifier,
    postsInfo: PostsInfo
) {
    Column(
        modifier = modifier.padding(
            horizontal = 10.dp,
            vertical = 6.dp
        ),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            postsInfo.title,
            style = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                fontSynthesis = FontSynthesis.Weight
            )
        )

        Box(
            modifier = Modifier
                .padding(6.dp)
                .background(
                    color = Color.LightGray,
                    shape = RoundedCornerShape(10.dp)
                )
        ) {
            Text(
                modifier = Modifier.padding(
                    horizontal = 10.dp,
                    vertical = 6.dp
                ),
                text = postsInfo.linkFlairText,
                style = TextStyle(
                    fontSize = 10.sp,
                    color = Color.Black
                )
            )
        }
    }
}