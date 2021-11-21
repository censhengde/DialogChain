package com.csd.dialogchain

/**

 * Author：岑胜德 on 2021/11/22 00:23

 * 说明：

 */
class DialogInterceptor : Interceptor {
    private var mChain: DialogChain? = null

    override fun intercept(chain: DialogChain) {
        mChain = chain
    }


    /*执行下一个拦截器*/
    fun next() {
        mChain?.process()
    }

    // 是否已经拦截。
    fun hasIntercepted() = mChain != null
}