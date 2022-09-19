package com.example.kt_project.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.kt_project.api.NetUrl
import com.example.kt_project.data.repository.UserRepository
import com.example.kt_project.entity.LoginUserinfo
import me.hgj.mvvmhelper.base.BaseViewModel
import me.hgj.mvvmhelper.ext.rxHttpRequest
import me.hgj.mvvmhelper.ext.rxHttpRequestCallBack
import me.hgj.mvvmhelper.net.LoadingType

/**
 *@author:好老师-App开发
 *@date:2022/9/15
 *@Description:登录viewmodel
 * 网络请求操作在viewmodel中处理
 */
class LoginViewModel : BaseViewModel() {
    //登录请求信息
    val loginData = MutableLiveData<LoginUserinfo>()

    /**
     *登录
     */
    fun loginapp(phoneNumber: String, password: String) {
        rxHttpRequest {
            onRequest = { loginData.value = UserRepository.login(phoneNumber, password).await()
            }
            loadingType = LoadingType.LOADING_DIALOG
            loadingMessage = "正在登录"
            requestCode = NetUrl.LOGIN
        }
    }
    fun loginCallBack(phoneNumber: String, password: String):MutableLiveData<LoginUserinfo>? {
        return rxHttpRequestCallBack {
            onRequest = {
                iAwaitLiveData?.value = UserRepository.login(phoneNumber,password).await()
            }
            loadingType = LoadingType.LOADING_DIALOG //选传 默认为 LoadingType.LOADING_NULL
            loadingMessage = "正在登录中....." // 选传
            requestCode = NetUrl.LOGIN // 选传，如果要判断接口错误业务的话必传
        }
    }
}