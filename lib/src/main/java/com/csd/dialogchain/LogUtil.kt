package com.csd.dialogchain

import android.util.Log

/**

 * Author：岑胜德 on 2021/11/26 22:26

 * 说明：

 */

internal var isOpenLog = false

internal fun String.logI(tagObj: Any) {
    if (isOpenLog) {
        Log.i(tagObj.javaClass.simpleName, this)
    }
}