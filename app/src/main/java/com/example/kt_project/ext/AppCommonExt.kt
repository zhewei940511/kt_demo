package com.example.kt_project.ext

import com.example.kt_project.R
import com.example.kt_project.widget.CustomToolBar


/**
 * 作者　: hegaojian
 * 时间　: 2021/6/9
 * 描述　:
 */

/**
 * 初始化有返回键的toolbar
 */
fun CustomToolBar.initBack(
    titleStr: String = "标题",
    backImg: Int = R.mipmap.ic_back,
    onBack: (toolbar: CustomToolBar) -> Unit
): CustomToolBar {
    this.setCenterTitle(titleStr)
    this.getBaseToolBar().setNavigationIcon(backImg)
    this.getBaseToolBar().setNavigationOnClickListener { onBack.invoke(this) }
    return this
}