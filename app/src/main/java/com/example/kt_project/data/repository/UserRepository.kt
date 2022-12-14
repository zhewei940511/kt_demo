package com.example.kt_project.data.repository

import com.example.kt_project.api.NetUrl
import com.example.kt_project.data.response.ApiResponse
import com.example.kt_project.entity.LoginUserinfo
import com.example.kt_project.util.MD5Util
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
    fun login(phone: String, pwd: String): Await<LoginUserinfo> {
        return RxHttp.postForm(NetUrl.LOGIN)
            .add("telephone", phone)
            .add("userPwd", pwd)
            .toResponse();
    }

    /**
     * 获取验证码
     */
    fun getcode(telephone: String, type: Int): Await<ApiResponse<Any>> {
        return RxHttp.postForm(NetUrl.GETCODE)
            .add("telephone", telephone).add("type", type).toResponse();
    }
}