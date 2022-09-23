package com.example.kt_project.api

import com.zhixinhuixue.zsyte.xxx.app.ext.mmkv
import com.zhixinhuixue.zsyte.xxx.data.annotation.ValueKey
import me.hgj.mvvmhelper.ext.getPhoneVersion
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
//        builder.addHeader("token", mmkv.getString(ValueKey.userToken,"").toString()).build()//token
//        builder.addHeader("device", "xiaomi").build()
//        builder.addHeader("channel","cretin_open_api").build()
//        builder.addHeader("uk", getPhoneVersion()).build()
//        builder.addHeader("app","1.0.0;1;10").build()
        builder.addHeader("token", "")//token
        builder.addHeader("device", "").build()
        builder.addHeader("channel","").build()
        builder.addHeader("uk", "").build()
        builder.addHeader("app","").build()
        return chain.proceed(builder.build())
    }
}