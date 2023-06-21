package com.thus.redditpost.ui.commoncomponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.minimumInteractiveComponentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.thus.redditpost.R
import com.thus.redditpost.domain.model.PostsInfo
import com.thus.redditpost.ui.util.WebUtil

@Composable
fun CustomImageWithOverlay(postsInfo: PostsInfo, webUtil: WebUtil) {

    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxWidth()) {
        // Display the image
        AsyncImage(
            model = ImageRequest.Builder(
                LocalContext.current
            ).data(postsInfo.thumbnail).crossfade(true).build(),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )

        // Show the small box overlay
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            contentAlignment = Alignment.Center,
            content = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .background(MaterialTheme.colorScheme.surface.copy(0.6f))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center)
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = postsInfo.domain,
                            style = TextStyle(textAlign = TextAlign.Center),
                        )
                        IconButton(
                            onClick = {
                                webUtil.launchCustomTab(
                                    context = context,
                                    url = postsInfo.urlOverriddenByDest
                                )
                            },
                            modifier = Modifier
                                .minimumInteractiveComponentSize()
                                .size(24.dp)
                        ) {
                            Icon(
                                painterResource(id = R.drawable.open_in_new_24),
                                contentDescription = "Open Link in Web",
                            )
                        }

                    }
                }
            }
        )
    }
}