package com.location.wanandroid.data
import androidx.recyclerview.widget.DiffUtil
import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json


/**
 *
 * @author tianxiaolong
 * time：4/16/21 10:02 PM
 * description：
 */

typealias PublicArticleData = WanResponse<List<PublicArticle>>

typealias PublicListData = WanResponse<PageData<PublicList>>

@JsonClass(generateAdapter = true)
data class PublicArticle(
    @Json(name = "children")
    val children: List<Any>,
    @Json(name = "courseId")
    val courseId: Int,
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "order")
    val order: Int,
    @Json(name = "parentChapterId")
    val parentChapterId: Int,
    @Json(name = "userControlSetTop")
    val userControlSetTop: Boolean,
    @Json(name = "visible")
    val visible: Int
)

@JsonClass(generateAdapter = true)
data class PublicList(
    @Json(name = "apkLink")
    val apkLink: String,
    @Json(name = "audit")
    val audit: Int,
    @Json(name = "author")
    val author: String,
    @Json(name = "canEdit")
    val canEdit: Boolean,
    @Json(name = "chapterId")
    val chapterId: Int,
    @Json(name = "chapterName")
    val chapterName: String,
    @Json(name = "collect")
    val collect: Boolean,
    @Json(name = "courseId")
    val courseId: Int,
    @Json(name = "desc")
    val desc: String,
    @Json(name = "descMd")
    val descMd: String,
    @Json(name = "envelopePic")
    val envelopePic: String,
    @Json(name = "fresh")
    val fresh: Boolean,
    @Json(name = "host")
    val host: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "link")
    val link: String,
    @Json(name = "niceDate")
    val niceDate: String,
    @Json(name = "niceShareDate")
    val niceShareDate: String,
    @Json(name = "origin")
    val origin: String,
    @Json(name = "prefix")
    val prefix: String,
    @Json(name = "projectLink")
    val projectLink: String,
    @Json(name = "publishTime")
    val publishTime: Long,
    @Json(name = "realSuperChapterId")
    val realSuperChapterId: Int,
    @Json(name = "selfVisible")
    val selfVisible: Int,
    @Json(name = "shareDate")
    val shareDate: Long?,
    @Json(name = "shareUser")
    val shareUser: String,
    @Json(name = "superChapterId")
    val superChapterId: Int,
    @Json(name = "superChapterName")
    val superChapterName: String,
    @Json(name = "tags")
    val tags: List<Tag>,
    @Json(name = "title")
    val title: String,
    @Json(name = "type")
    val type: Int,
    @Json(name = "userId")
    val userId: Int,
    @Json(name = "visible")
    val visible: Int,
    @Json(name = "zan")
    val zan: Int
){

    class DiffCallback: DiffUtil.ItemCallback<PublicList>() {
        override fun areItemsTheSame(oldItem: PublicList, newItem: PublicList): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PublicList, newItem: PublicList): Boolean {
            return oldItem == newItem
        }

    }
}


