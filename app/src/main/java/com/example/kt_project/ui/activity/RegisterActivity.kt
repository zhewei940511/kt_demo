package com.example.kt_project.ui.activity

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.viewbinding.ViewBinding
import com.example.kt_project.R
import com.example.kt_project.base.BaseActivity
import com.example.kt_project.databinding.ActivityRegisterBinding
import com.example.kt_project.ext.initBack
import com.example.kt_project.ui.viewmodel.RegisterViewModel
import com.hjq.toast.ToastUtils
import me.hgj.mvvmhelper.ext.getStringExt
import me.hgj.mvvmhelper.ext.setOnclick
import me.hgj.mvvmhelper.net.LoadStatusEntity

/**
 *@author:好老师-App开发
 *@date:2022/9/27
 *@Description:
 */

class RegisterActivity :BaseActivity<RegisterViewModel,ActivityRegisterBinding>(){
    override fun initView(savedInstanceState: Bundle?) {
        //初始化toolbar
        //可以主动设置沉浸式的颜色，应对ui比较呆的情况下，搞得title颜色不一致如果不设置就默认为主体色
//        mToolbar.setBackgroundColor(Color.parseColor("#fd46a8"))
        mToolbar.initBack(getStringExt(R.string.login_register)) {
            finish()
        }
    }
    //请求成功
    override fun onRequestSuccess() {
        mViewModel.getCodeData.observe(this, Observer {
            ToastUtils.show("验证码获取成功")
        })
    }
//    //请求失败
//    override fun onRequestError(loadStatus: LoadStatusEntity) {
//        super.onRequestError(loadStatus)
//    }
    //按钮监听事件
    override fun onBindViewClick() {
        setOnclick(mBind.tvRegisteredphonecode,mBind.btnRegistered){
         when(it){
             //获取验证码
             mBind.tvRegisteredphonecode->{
                mViewModel.getcodeCallBack()?.observe(this)
                {
                    ToastUtils.show("验证码获取成功")
                }
             }
             //注册
             mBind.btnRegistered->{

             }
         }
        }
    }
}