package com.example.kt_project.api

import rxhttp.wrapper.annotation.DefaultDomain

/**
 *@author:好老师-App开发
 *@date:2022/9/15
 *@Description:
 */
object NetUrl {
    // 服务器请求成功的 Code值
    const val SUCCESS_CODE = 200
//    http://fenzijia.com/app/
//    http://tools.cretinzp.com/jokes
    @DefaultDomain//默认域名
    const val DEV_URL="http://api.hls.seevin.com";
    //验证码登录
    const val LOGIN="/business/student/loginIn";
    //获取验证码
    const val GETCODE="/business/student/sendMsgCode";
}