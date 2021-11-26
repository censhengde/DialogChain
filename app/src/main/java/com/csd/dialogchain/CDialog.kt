package com.csd.dialogchain

import android.content.Context
import android.os.Bundle
import android.view.View

/**

 * Author：岑胜德 on 2021/11/26 21:42

 * 说明：

 */
class CDialog(context: Context) : BaseDialog(context), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_c)
        findViewById<View>(R.id.tv_confirm)?.setOnClickListener(this)
        findViewById<View>(R.id.tv_cancel)?.setOnClickListener(this)
        // 弹窗消失时把请求移交给下一个拦截器。
        setOnDismissListener {
            chain()?.process()
        }
    }

    override fun onClick(p0: View?) {
        dismiss()
    }

    override fun intercept(chain: DialogChain) {
        super.intercept(chain)
        val isShow = true // 这里可根据实际业务场景来定制dialog 显示条件。
        if (isShow) {
            this.show()
        } else { // 当自己不具备弹出条件的时候，可以立刻把请求转交给下一个拦截器。
            chain.process()
        }
    }
}