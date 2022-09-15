package com.example.kt_project.data.repository

import com.example.kt_project.api.NetUrl
import com.example.kt_project.entity.LoginUserinfo
import rxhttp.wrapper.coroutines.Await
import rxhttp.wrapper.param.RxHttp
import rxhttp.wrapper.param.toResponse

/**
 *@author:好老师-App开发
 *@date:2022/9/15
 *@Description:
 * 接口请求
 */
object UserRepository {
    /**
     * 登录
     */
    fun login(phone:String,pwd:String): Await<LoginUserinfo> {
        return RxHttp.postForm(NetUrl.LOGIN)
            .add("phone", phone)
            .add("pwd", pwd)
            .toResponse();
    }
}