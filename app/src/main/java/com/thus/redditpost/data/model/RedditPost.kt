package com.thus.redditpost.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.thus.redditpost.domain.model.PostsInfo

@Entity(tableName = "RedditPost")
data class RedditPost(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val linkFlairText: String = "",
    val title: String = "",
    val domain: String = "",
    val author: String = "",
    val thumbnail: String = "",
    val urlOverriddenByDest: String = "",
    val created: Double = 0.0,
    val ups: Int = 0,
    val numComments: Int = 0,
    val after: String = "",
    val subredditNamePrefixed: String = ""
)

fun PostsInfo.toRedditPost() = RedditPost(
    linkFlairText = linkFlairText,
    title = title,
    domain = domain,
    author = author,
    thumbnail = thumbnail,
    urlOverriddenByDest = urlOverriddenByDest,
    created = created,
    ups = ups,
    numComments = numComments,
    subredditNamePrefixed = subredditNamePrefixed
)

fun PostsResponse.toRedditPostList(): List<RedditPost> =
    postData?.children?.mapNotNull { children ->
        children.childrenData?.toPostsInfo(postData.after.orEmpty())
    }.orEmpty()

fun ChildrenData.toPostsInfo(after: String): RedditPost =
    RedditPost(
        linkFlairText = link_flair_text.orEmpty(),
        title = title.orEmpty(),
        domain = domain.orEmpty(),
        author = author.orEmpty(),
        thumbnail = thumbnail.orEmpty(),
        urlOverriddenByDest = url_overridden_by_dest.orEmpty(),
        created = created ?: 0.0,
        ups = ups ?: 0,
        after = after,
        subredditNamePrefixed = subreddit_name_prefixed.orEmpty()
    )
