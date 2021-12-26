package com.neppplus.finalproject_logictest_20211226

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

// 상속 허용 방법 -> 1. open,  2. abstract

abstract class BaseActivity : AppCompatActivity() {

    lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mContext = this
    }

    abstract fun setupEvents()
    abstract fun setValues()

}