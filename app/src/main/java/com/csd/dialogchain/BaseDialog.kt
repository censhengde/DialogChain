package com.csd.dialogchain

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AlertDialog

/**

 * Author：岑胜德 on 2021/11/26 21:42

 * 说明：

 */
abstract class BaseDialog(context: Context):AlertDialog(context),Interceptor {
    private var mChain: DialogChain? = null

    @CallSuper
    override fun intercept(chain: DialogChain) {
        mChain = chain
    }


    /*执行下一个拦截器*/
    fun chain(): DialogChain? = mChain

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.attributes?.width=800
        window?.attributes?.height=900


    }


}