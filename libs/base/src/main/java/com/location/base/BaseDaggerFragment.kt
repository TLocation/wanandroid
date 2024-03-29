package com.location.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.location.base.delegate.DaggerFragmentDelegate
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
 *
 * @author tianxiaolong
 * time：2021/2/27 10:53 PM
 * description：
 */
abstract class BaseDaggerFragment<T: ViewDataBinding> : BaseFragment<T>(), HasAndroidInjector {



    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>


    /**
     * 是否支持依赖注入
     * @return Boolean
     */
    fun supportInject() = true


    override fun onAttach(context: Context) {
        if(supportInject()){
            DaggerFragmentDelegate.create().inject(this)
        }
        super.onAttach(context)
    }


    override fun androidInjector(): AndroidInjector<Any?>? {
        return androidInjector
    }

}