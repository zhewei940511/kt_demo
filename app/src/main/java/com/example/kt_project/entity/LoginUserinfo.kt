package com.example.kt_project.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 *@author:好老师-App开发
 *@date:2022/9/15
 *@Description:
 * 登录实体类
 */
@Parcelize
data  class LoginUserinfo (
    var token : String = ""
): Parcelable