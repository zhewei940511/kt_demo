package com.example.kt_project.api

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 *@author:好老师-App开发
 *@date:2022/9/15
 *@Description:
 * 自定义拦截器
 */
class HeadInterceptor : Interceptor{
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        //模拟了2个公共参数
        builder.addHeader("token", "token123456").build()
        builder.addHeader("device", "Android").build()
        return chain.proceed(builder.build())
    }
}