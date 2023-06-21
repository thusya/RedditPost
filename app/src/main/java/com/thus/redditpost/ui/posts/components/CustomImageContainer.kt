package com.thus.redditpost.ui.posts.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.thus.redditpost.domain.model.PostsInfo

@Composable
fun CustomImageContainer(
    postsInfo: PostsInfo
) {

    var sizeImage by remember { mutableStateOf(IntSize.Zero) }

    val shape = RoundedCornerShape(8.dp)
    val height = 60.dp

    Box(
        modifier = Modifier
            .height(height)
            .width(110.dp)
            .background(color = Transparent, shape = shape),
        contentAlignment = Alignment.Center

    ) {

        AsyncImage(
            model = ImageRequest.Builder(
                LocalContext.current
            )
                .data(postsInfo.thumbnail)
                .crossfade(true)
                .build(),

            contentDescription = "",
            modifier = Modifier
                .width(110.dp)
                .height(60.dp)
                .clip(RoundedCornerShape(8.dp))

                .onGloballyPositioned {
                    sizeImage = it.size
                },
        )

//        GlideImage(
//            model = postsInfo.thumbnail,
//            contentDescription = "Image",
//            modifier = Modifier
//                .padding(3.dp)
//                .fillMaxSize(),
//        )

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .background(Color.Black.copy(alpha = 0.6f))
                .fillMaxWidth()
        ) {

            Text(
                text = postsInfo.domain,
                color = Color.White,
                fontSize = 10.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(vertical = 4.dp)
            )
        }
    }
}
