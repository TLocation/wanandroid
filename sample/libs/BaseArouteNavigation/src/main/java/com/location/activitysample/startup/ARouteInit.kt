package com.location.activitysample.startup

import android.app.Application
import android.content.Context
import androidx.startup.Initializer
import com.alibaba.android.arouter.launcher.ARouter
import com.location.baseARouteNavigation.BuildConfig

/**
 *
 * @author tianxiaolong
 * time：5/19/21 10:58 PM
 * description：
 */
class ARouteInit: Initializer<Boolean> {
    override fun create(context: Context): Boolean {
        if (BuildConfig.DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog()     // 打印日志
            ARouter.openDebug()   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(context as Application)
        return true
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf()
    }
}