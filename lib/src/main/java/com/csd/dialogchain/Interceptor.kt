package com.csd.dialogchain

/**

 * Author：岑胜德 on 2021/11/21 23:40

 * 说明：

 */
interface Interceptor {

    fun intercept(chain: DialogChain)
}