package com.location.wanandroid

import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor
import com.location.base.logDebug
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitUtils {
    private const val BASE_URL = "https://wanandroid.com/"
    val cookieManager by lazy {
        PersistentCookieJar(
            SetCookieCache(), SharedPrefsCookiePersistor(
                appContext
            )
        )
    }
    private val retrofit: Retrofit by lazy {

        Retrofit.Builder()
            .run {
                addConverterFactory(MoshiConverterFactory.create())
                baseUrl(BASE_URL)
                    .client(
                        OkHttpClient.Builder()
                            .cookieJar(cookieManager)
                            .run {
                                if (BuildConfig.DEBUG) {
                                    addNetworkInterceptor(HttpLoggingInterceptor(HttpLog()).apply {
                                        level = HttpLoggingInterceptor.Level.BODY
                                    })
                                }

                                build()
                            }

                    )
                build()
            }

    }


    fun <T> create(clazz: Class<T>): T = retrofit.create(clazz)
}

class HttpLog : HttpLoggingInterceptor.Logger {
    override fun log(message: String?) {
        message?.let {
            logDebug("HttpLog", it)
        }
    }

}