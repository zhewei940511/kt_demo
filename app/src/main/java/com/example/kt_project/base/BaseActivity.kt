package com.example.kt_project.base

import android.view.LayoutInflater
import android.view.View
import androidx.viewbinding.ViewBinding
import com.example.kt_project.R
import com.example.kt_project.widget.CustomToolBar
import com.gyf.immersionbar.ImmersionBar
import me.hgj.mvvmhelper.base.BaseDbActivity
import me.hgj.mvvmhelper.base.BaseVBActivity
import me.hgj.mvvmhelper.base.BaseViewModel

/**
 * 作者　: zw
 * 时间　: 2022/9/14
 * 描述　: 使用了 ViewBinding的基类 需要自定义修改什么就重写什么 具体方法可以 搜索 BaseIView 查看
 */
abstract class BaseActivity<VM:BaseViewModel,VB:ViewBinding>: BaseVBActivity<VM, VB>() {
    //全局的toolbar
    lateinit var mToolbar: CustomToolBar
    override fun getTitleBarView(): View? {
        val titleBarView = LayoutInflater.from(this).inflate(R.layout.layout_titlebar_view, null)
        mToolbar = titleBarView.findViewById(R.id.customToolBar)
        return titleBarView
    }

    override fun initImmersionBar() {
        //设置共同沉浸式样式
        if (showToolBar()) {
            mToolbar.setBackgroundResource(R.color.colorPrimary)
            ImmersionBar.with(this).titleBar(mToolbar).init()
        }
    }
}