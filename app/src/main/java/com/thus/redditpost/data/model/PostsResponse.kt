package com.thus.redditpost.data.model

import com.squareup.moshi.Json
import com.thus.redditpost.domain.model.PostsInfo

data class PostsResponse(
    @field:Json(name = "kind")
    val kind: String? = null,

    @field:Json(name = "data")
    val postData: PostsData? = null
)

fun PostsResponse.toPostsInfoList(): List<PostsInfo> =
    postData?.children?.mapNotNull { children ->
        children.childrenData?.toPostsInfo(postData.after)
    }.orEmpty()

fun ChildrenData.toPostsInfo(after: String?): PostsInfo =
    PostsInfo(
        linkFlairText = link_flair_text.orEmpty(),
        title = title.orEmpty(),
        domain = domain.orEmpty(),
        author = author.orEmpty(),
        thumbnail = thumbnail.orEmpty(),
        urlOverriddenByDest = url_overridden_by_dest.orEmpty(),
        created = created ?: 0.0,
        ups = ups ?: 0,
        numComments = num_comments ?: 0,
        after = after.orEmpty(),
        subredditNamePrefixed = subreddit_name_prefixed.orEmpty()
    )
