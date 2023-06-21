package com.thus.redditpost.ui.commoncomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thus.redditpost.R
import com.thus.redditpost.domain.model.PostsInfo

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
                text = postsInfo.ups.toString(),
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
            Spacer(modifier = Modifier.width(2.dp))
            Text(
                text = postsInfo.numComments.toString(),
                style = TextStyle(
                    color = Color.Gray
                )
            )
        }
    }
}


//val postData = PostsInfo(linkFlairText="TechSupport", title="Got a tech question or want to discuss tech? Bi-Weekly /r/Technology Tech Support / General Discussion Thread", domain="self.technology", author="veritanuda", thumbnail="self", urlOverriddenByDest="", created=1.685862202E9, ups=57, numComments=73, after="t3_14eazna")
//val postData1 = PostsInfo(linkFlairText="Energy", title="Texas power use to break records in heat wave, prices soar to $2,500 per megawatt hour - ERCOT", domain="reuters.com", author="geoxol", thumbnail="https://b.thumbs.redditmedia.com/G7L1PA5rcMbK1fK1cg36LcHMiHt69NlkUX-gY11SFTU.jpg", urlOverriddenByDest="https://www.reuters.com/world/us/texas-power-use-break-records-heat-wave-prices-soar-ercot-2023-06-20/", created=1.68727451E9, ups=1221, numComments=375, after="t3_14eazna")