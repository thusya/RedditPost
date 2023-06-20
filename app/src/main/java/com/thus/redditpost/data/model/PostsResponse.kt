package com.thus.redditpost.data.model

import com.squareup.moshi.Json
import com.thus.redditpost.domain.model.PostsInfo

data class PostsResponse(
    @field:Json(name = "kind")
    val kind: String? = null,

    @field:Json(name = "data")
    val postData: PostsData? = null
)

fun PostsResponse.toPostsInfoList(): List<PostsInfo> {
    val postsInfoList: MutableList<PostsInfo> = mutableListOf()

    val childrenList = postData?.children

    childrenList?.map { children ->
        val childrenData = children.childrenData

        childrenData?.let { data ->
            val linkFlairText = data.link_flair_text.orEmpty()
            val title = data.title.orEmpty()
            val domain = data.domain.orEmpty()
            val author = data.author.orEmpty()
            val thumbnail = data.thumbnail.orEmpty()
            val urlOverriddenByDest = data.url_overridden_by_dest.orEmpty()
            val created = data.created ?: 0.0
            val ups = data.ups ?: 0
            val numComments = data.num_comments ?: 0

            val postsInfo = PostsInfo(
                linkFlairText = linkFlairText,
                title = title,
                domain = domain,
                author = author,
                thumbnail = thumbnail,
                urlOverriddenByDest = urlOverriddenByDest,
                created = created,
                ups = ups,
                num_comments = numComments,
                after = postData?.after.orEmpty()
            )

            postsInfoList.add(postsInfo)
        }
    }

    return postsInfoList
}
