package com.location.wanandroid.view.collect

import android.os.Bundle
import com.location.base.BaseActivity
import com.location.base.BaseDaggerActivity
import com.location.wanandroid.R
import com.location.wanandroid.adapter.collect.CollectFragmentAdapter
import com.location.wanandroid.databinding.ActivityCollectBinding

/**
 *
 * @author tianxiaolong
 * time：2021/3/6 4:37 PM
 * description：
 */
class CollectActivity: BaseDaggerActivity<ActivityCollectBinding>(){
    override val layoutId: Int
        get() = R.layout.activity_collect

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding.viewPager.adapter =
             CollectFragmentAdapter(
                 supportFragmentManager, mutableListOf(
                     CollectArticleFragment(),
                     CollectWebsiteFragment()

                 ), mutableListOf("文章", "网址")
             )
        binding.tableLayout.setupWithViewPager(binding.viewPager)

    }

}

