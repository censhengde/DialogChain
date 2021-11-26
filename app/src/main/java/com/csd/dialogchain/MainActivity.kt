package com.csd.dialogchain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    private lateinit var dialogChain: DialogChain
    private val bDialog by lazy { BDialog(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DialogChain.openLog(true)
        createDialogChain()
        // 模拟延迟数据回调。
        Handler().postDelayed({
            bDialog.onDataCallback("延迟数据回来了！！")
        },10000)
    }

    private fun createDialogChain() {
        dialogChain = DialogChain.create(3)
            .attach(this)
            .addInterceptor(ADialog(this))
            .addInterceptor(bDialog)
            .addInterceptor(CDialog(this))
            .build()

    }

    override fun onStart() {
        super.onStart()
        dialogChain.process()
    }
}
