package com.location.network

import com.location.network.response.BaseResponse
import com.location.network.response.Result

/**
 *
 * @author tianxiaolong
 * time：2021/3/27 12:05 AM
 * description：
 */


inline fun <T> Result<T>.parseResult(
    success: (data: T) -> Unit,
    noinline errorBlock: ((code: Int, msg: String) -> Unit)? = null
) {
    when (this) {
        is Result.Success -> success(data)
        is Result.Fail -> errorBlock?.invoke(code, error.message!!)
    }
}

/**
 * BaseResponse 扩展函数 执行请求
 */
suspend inline fun <T> BaseResponse<T>.transform():Result<T> = executeResponse(this)