package com.example.kt_project.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.kt_project.api.NetUrl
import com.example.kt_project.data.repository.UserRepository
import com.example.kt_project.data.response.ApiResponse
import com.example.kt_project.entity.LoginUserinfo
import com.example.kt_project.util.MD5Util
import me.hgj.mvvmhelper.base.BaseViewModel
import me.hgj.mvvmhelper.ext.rxHttpRequestCallBack
import me.hgj.mvvmhelper.net.LoadingType

/**
 *@author:好老师-App开发
 *@date:2022/9/27
 *@Description:
 */
class RegisterViewModel:BaseViewModel() {
    //获取验证码
    val getCodeData=MutableLiveData<ApiResponse<Any>>();
    //获取验证码
    fun getcodeCallBack():MutableLiveData<ApiResponse<Any>>? {
        return rxHttpRequestCallBack {
            onRequest = {
                iAwaitLiveData?.value = UserRepository.getcode("17318203548",2).await();
            }
            loadingType = LoadingType.LOADING_DIALOG //选传 默认为 LoadingType.LOADING_NULL
            loadingMessage = "正在登录中....." // 选传
            requestCode = NetUrl.LOGIN // 选传，如果要判断接口错误业务的话必传
        }
    }
}