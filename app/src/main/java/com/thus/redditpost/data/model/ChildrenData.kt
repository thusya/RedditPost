package com.thus.redditpost.data.model

import com.squareup.moshi.Json

data class ChildrenData(
    @field:Json(name = "all_awardings")
    val all_awardings: List<AllAwarding>? = null,

    @field:Json(name = "allow_live_comments")
    val allow_live_comments: Boolean? = null,

    @field:Json(name = "approved_at_utc")
    val approved_at_utc: Any? = null,

    @field:Json(name = "approved_by")
    val approved_by: Any? = null,

    @field:Json(name = "archived")
    val archived: Boolean? = null,

    @field:Json(name = "author")
    val author: String? = null,

    @field:Json(name = "author_flair_background_color")
    val author_flair_background_color: Any? = null,

    @field:Json(name = "author_flair_css_class")
    val author_flair_css_class: Any? = null,

    @field:Json(name = "author_flair_richtext")
    val author_flair_richtext: List<Any>? = null,

    @field:Json(name = "author_flair_template_id")
    val author_flair_template_id: Any? = null,

    @field:Json(name = "author_flair_text")
    val author_flair_text: Any? = null,

    @field:Json(name = "author_flair_text_color")
    val author_flair_text_color: Any? = null,

    @field:Json(name = "author_flair_type")
    val author_flair_type: String? = null,

    @field:Json(name = "author_fullname")
    val author_fullname: String? = null,

    @field:Json(name = "author_is_blocked")
    val author_is_blocked: Boolean? = null,

    @field:Json(name = "author_patreon_flair")
    val author_patreon_flair: Boolean? = null,

    @field:Json(name = "author_premium")
    val author_premium: Boolean? = null,

    @field:Json(name = "awarders")
    val awarders: List<Any>? = null,

    @field:Json(name = "banned_at_utc")
    val banned_at_utc: Any? = null,

    @field:Json(name = "banned_by")
    val banned_by: Any? = null,

    @field:Json(name = "can_gild")
    val can_gild: Boolean? = null,

    @field:Json(name = "can_mod_post")
    val can_mod_post: Boolean? = null,

    @field:Json(name = "category")
    val category: Any? = null,

    @field:Json(name = "clicked")
    val clicked: Boolean? = null,

    @field:Json(name = "content_categories")
    val content_categories: Any? = null,

    @field:Json(name = "contest_mode")
    val contest_mode: Boolean? = null,

    @field:Json(name = "created")
    val created: Double? = null,

    @field:Json(name = "created_utc")
    val created_utc: Double? = null,

    @field:Json(name = "discussion_type")
    val discussion_type: Any? = null,

    @field:Json(name = "distinguished")
    val distinguished: Any? = null,

    @field:Json(name = "domain")
    val domain: String? = null,

    @field:Json(name = "downs")
    val downs: Int? = null,

    @field:Json(name = "edited")
    val edited: Boolean? = null,

    @field:Json(name = "gilded")
    val gilded: Int? = null,

    @field:Json(name = "gildings")
    val gildings: Gildings? = null,

    @field:Json(name = "hidden")
    val hidden: Boolean? = null,

    @field:Json(name = "hide_score")
    val hide_score: Boolean? = null,

    @field:Json(name = "id")
    val id: String? = null,

    @field:Json(name = "is_created_from_ads_ui")
    val is_created_from_ads_ui: Boolean? = null,

    @field:Json(name = "is_crosspostable")
    val is_crosspostable: Boolean? = null,

    @field:Json(name = "is_meta")
    val is_meta: Boolean? = null,

    @field:Json(name = "is_original_content")
    val is_original_content: Boolean? = null,

    @field:Json(name = "is_reddit_media_domain")
    val is_reddit_media_domain: Boolean? = null,

    @field:Json(name = "is_robot_indexable")
    val is_robot_indexable: Boolean? = null,

    @field:Json(name = "is_self")
    val is_self: Boolean? = null,

    @field:Json(name = "is_video")
    val is_video: Boolean? = null,

    @field:Json(name = "likes")
    val likes: Any? = null,

    @field:Json(name = "link_flair_background_color")
    val link_flair_background_color: String? = null,

    @field:Json(name = "link_flair_css_class")
    val link_flair_css_class: String? = null,

    @field:Json(name = "link_flair_richtext")
    val link_flair_richtext: List<Any>? = null,

    @field:Json(name = "link_flair_template_id")
    val link_flair_template_id: String? = null,

    @field:Json(name = "link_flair_text")
    val link_flair_text: String? = null,

    @field:Json(name = "link_flair_text_color")
    val link_flair_text_color: String? = null,

    @field:Json(name = "link_flair_type")
    val link_flair_type: String? = null,

    @field:Json(name = "locked")
    val locked: Boolean? = null,

    @field:Json(name = "media")
    val media: Any? = null,

    @field:Json(name = "media_embed")
    val media_embed: MediaEmbed? = null,

    @field:Json(name = "media_only")
    val media_only: Boolean? = null,

    @field:Json(name = "mod_note")
    val mod_note: Any? = null,

    @field:Json(name = "mod_reason_by")
    val mod_reason_by: Any? = null,

    @field:Json(name = "mod_reason_title")
    val mod_reason_title: Any? = null,

    @field:Json(name = "mod_reports")
    val mod_reports: List<Any>? = null,

    @field:Json(name = "name")
    val name: String? = null,

    @field:Json(name = "no_follow")
    val no_follow: Boolean? = null,

    @field:Json(name = "num_comments")
    val num_comments: Int? = null,

    @field:Json(name = "num_crossposts")
    val num_crossposts: Int? = null,

    @field:Json(name = "num_reports")
    val num_reports: Any? = null,

    @field:Json(name = "over_18")
    val over_18: Boolean? = null,

    @field:Json(name = "parent_whitelist_status")
    val parent_whitelist_status: String? = null,

    @field:Json(name = "permalink")
    val permalink: String? = null,

    @field:Json(name = "pinned")
    val pinned: Boolean? = null,

    @field:Json(name = "post_hint")
    val post_hint: String? = null,

    @field:Json(name = "preview")
    val preview: Preview? = null,

    @field:Json(name = "pwls")
    val pwls: Int? = null,

    @field:Json(name = "quarantine")
    val quarantine: Boolean? = null,

    @field:Json(name = "removal_reason")
    val removal_reason: Any? = null,

    @field:Json(name = "removed_by")
    val removed_by: Any? = null,

    @field:Json(name = "removed_by_category")
    val removed_by_category: Any? = null,

    @field:Json(name = "report_reasons")
    val report_reasons: Any? = null,

    @field:Json(name = "saved")
    val saved: Boolean? = null,

    @field:Json(name = "score")
    val score: Int? = null,

    @field:Json(name = "secure_media")
    val secure_media: Any? = null,

    @field:Json(name = "secure_media_embed")
    val secure_media_embed: SecureMediaEmbed? = null,

    @field:Json(name = "selftext")
    val selftext: String? = null,

    @field:Json(name = "selftext_html")
    val selftext_html: String? = null,

    @field:Json(name = "send_replies")
    val send_replies: Boolean? = null,

    @field:Json(name = "spoiler")
    val spoiler: Boolean? = null,

    @field:Json(name = "stickied")
    val stickied: Boolean? = null,

    @field:Json(name = "subreddit")
    val subreddit: String? = null,

    @field:Json(name = "subreddit_id")
    val subreddit_id: String? = null,

    @field:Json(name = "subreddit_name_prefixed")
    val subreddit_name_prefixed: String? = null,

    @field:Json(name = "subreddit_subscribers")
    val subreddit_subscribers: Int? = null,

    @field:Json(name = "subreddit_type")
    val subreddit_type: String? = null,

    @field:Json(name = "suggested_sort")
    val suggested_sort: Any? = null,

    @field:Json(name = "thumbnail")
    val thumbnail: String? = null,

    @field:Json(name = "thumbnail_height")
    val thumbnail_height: Int? = null,

    @field:Json(name = "thumbnail_width")
    val thumbnail_width: Int? = null,

    @field:Json(name = "title")
    val title: String? = null,

    @field:Json(name = "top_awarded_type")
    val top_awarded_type: Any? = null,

    @field:Json(name = "total_awards_received")
    val total_awards_received: Int? = null,

    @field:Json(name = "treatment_tags")
    val treatment_tags: List<Any>? = null,

    @field:Json(name = "ups")
    val ups: Int? = null,

    @field:Json(name = "upvote_ratio")
    val upvote_ratio: Double? = null,

    @field:Json(name = "url")
    val url: String? = null,

    @field:Json(name = "url_overridden_by_dest")
    val url_overridden_by_dest: String? = null,

    @field:Json(name = "user_reports")
    val user_reports: List<Any>? = null,

    @field:Json(name = "view_count")
    val view_count: Any? = null,

    @field:Json(name = "visited")
    val visited: Boolean? = null,

    @field:Json(name = "whitelist_status")
    val whitelist_status: String? = null,

    @field:Json(name = "wls")
    val wls: Int? = null
)