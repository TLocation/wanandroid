package com.location.wanandroid.padingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.location.network.response.Result
import com.location.base.logDebug
import com.location.wanandroid.data.HomeData
import com.location.wanandroid.data.HomeListData
import com.location.wanandroid.data.findNextIndex
import com.location.wanandroid.repository.HomeRepository

/**
 *
 * @author tianxiaolong
 * time：2021/2/27 11:10 PM
 * description：
 */
class HomeSource(private val homeRep: HomeRepository, private val type: HomeSourceType) :
    PagingSource<Int, HomeListData>() {
    companion object {
        private const val TAG = "HomeSource"
    }

    override fun getRefreshKey(state: PagingState<Int, HomeListData>): Int? {
        logDebug(TAG, "getRefreshKey")
        return 0
    }


    private suspend fun loadData(loadIndex: Int): Result<HomeData> {
        return when (type) {
            HomeSourceType.HOME_DATA -> homeRep.loadHomeData(loadIndex)
            HomeSourceType.QA_DATA -> homeRep.loadQAData(loadIndex)
            else -> throw UnsupportedOperationException("not support type is ${type.name}")
        }
    }

    /**
     * paging3加载数据
     */
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, HomeListData> {
        // 获取加载的索引 没有就从0开始
        val loadIndex = params.key ?: 0

        logDebug(TAG, "load loadIndex=$loadIndex")
        return when (val response = loadData(loadIndex)) {
            is Result.Success -> LoadResult.Page(
                data = response.data.datas,
                prevKey = null,
                nextKey = response.data.findNextIndex(loadIndex)
            )

            is Result.Fail -> LoadResult.Error(response.error)
        }
    }
}

enum class HomeSourceType {
    HOME_DATA,
    QA_DATA,
    PUBLIC_ARTICLE,
}