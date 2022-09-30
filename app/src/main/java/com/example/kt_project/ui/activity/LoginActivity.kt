package com.example.kt_project.ui.activity

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import androidx.lifecycle.Observer
import com.example.kt_project.R
import com.example.kt_project.api.NetUrl
import com.example.kt_project.base.BaseActivity
import com.example.kt_project.databinding.ActivityLoginBinding
import com.example.kt_project.ext.initBack
import com.example.kt_project.ui.viewmodel.LoginViewModel
import com.hjq.toast.ToastUtils
import com.zhixinhuixue.zsyte.xxx.app.ext.mmkv
import com.zhixinhuixue.zsyte.xxx.data.annotation.ValueKey
import me.hgj.mvvmhelper.ext.*
import me.hgj.mvvmhelper.net.LoadStatusEntity

/**
 * 登录界面
 */
class LoginActivity : BaseActivity<LoginViewModel, ActivityLoginBinding>() {
    override fun initView(savedInstanceState: Bundle?) {
        //初始化toolbar
        mToolbar.initBack(getStringExt(R.string.login_submit)) {
            finish()
        }
    }

    override fun onRequestSuccess() {
        mViewModel.loginData.observe(this, Observer {
            //请求成功  可以做保存信息等操作 ....
            LiveDataEvent.loginEvent.value = true //通知登录成功
            finish()
        })
    }

    override fun onRequestError(loadStatus: LoadStatusEntity) {

        when (loadStatus.requestCode) {
            NetUrl.LOGIN -> {
                //是登录接口 ，弹窗提示错误消息
                showDialogMessage(
                    loadStatus.errorMessage,
                    "温馨提示",
                    "确定"
                )
            }
        }
    }

    override fun onBindViewClick() {
        setOnclick(mBind.ivLogin, mBind.tvForgetpwd,mBind.tvRegistered)
        {
            when (it) {
                //登录界面
                mBind.ivLogin -> {
                    when {
                        mBind.etLoginphone.isEmpty() -> ToastUtils.show("手机号不能为空")
                        mBind.etLoginpwd.isEmpty() -> ToastUtils.show("密码不能为空")
                        else -> {
                            mViewModel.loginCallBack(
                                mBind.etLoginphone.textString(),
                                mBind.etLoginpwd.textString()
                            )?.observe(this) {
                                //请求成功  可以做保存信息等操作 ....
                                mmkv.putString(ValueKey.userToken,it.token)//保存token
                                LiveDataEvent.loginEvent.value = true //通知登录成功
                                finish()
                            }
                        }
                    }
                }
                //忘记密码点击事件
                mBind.tvForgetpwd -> {
                    ToastUtils.show("点击了忘记密码")
                }
                //注册界面
                mBind.tvRegistered->{
                    toStartActivity(RegisterActivity::class.java)
                }
            }

        }
    }

    //是否显示标题
    override fun showToolBar(): Boolean {
        return false;
    }
}