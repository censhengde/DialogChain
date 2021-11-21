package com.csd.dialogchain

import android.content.Context
import java.util.ArrayList

/**

 * Author：岑胜德 on 2021/11/21 23:38

 * 说明：

 */
open class DialogChain private constructor(
    val context: Context,
    private val interceptors: MutableList<Interceptor>,
    private val index: Int = 0
) {
    companion object {
        @JvmStatic
        fun create(context: Context, initialCapacity: Int = 0): Builder {
            return Builder(context, initialCapacity)
        }
    }


    fun process() {
        when (index) {
            in interceptors.indices -> {
                val next = DialogChain(context, interceptors, index + 1)
                interceptors[index].intercept(next)
            }
            interceptors.size -> {
                clearInterceptor()
            }
        }
    }

    private fun clearInterceptor() {
        interceptors.clear()
    }

    open class Builder(private val context: Context, private val initialCapacity: Int = 0) {
        private val interceptors by lazy { ArrayList<Interceptor>(initialCapacity) }

        fun addInterceptor(interceptor: Interceptor): Builder {
            if (!interceptors.contains(interceptor)) {
                interceptors.add(interceptor)
            }
            return this
        }

        fun build(): DialogChain {
            return DialogChain(context, interceptors)
        }
    }


}