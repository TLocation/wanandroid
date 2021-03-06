package com.location.wanandroid.http

import com.location.base.EmptyData
import com.location.wanandroid.data.WanResponse
import com.location.wanandroid.data.UserData
import com.location.wanandroid.data.WanCollectArticle
import retrofit2.http.*

interface UserService {
    @FormUrlEncoded
    @POST(LOGIN)
    suspend fun login(
        @Field("username") userName: String,
        @Field("password") pwd: String
    ): WanResponse<UserData>

    /**
     * 收藏站内文章 id为收藏的文章id
     * {
    "data": null,
    "errorCode": 0,
    "errorMsg": ""
    }
     */
    @POST("lg/collect/{collectId}/json")
    suspend fun collectArticle(@Path("collectId") id: Long): WanResponse<EmptyData>

    /**
     * 收藏站内文章 id为收藏的文章id
     * {
    "data": null,
    "errorCode": 0,
    "errorMsg": ""
    }
     */
    @POST("lg/uncollect_originId/{collectId}/json")
    suspend fun unCollectArticle(@Path("collectId") id: Long): WanResponse<EmptyData>


    /**
     * 退出登陆
     *
     */
    @GET("user/logout/json")
    suspend fun unLogout(): WanResponse<EmptyData>


    /**
     *获取收藏文章列表
     */
    @GET("lg/collect/list/{path}/json")
    suspend fun  getCollectList(@Path("path") index:Int):WanCollectArticle




}