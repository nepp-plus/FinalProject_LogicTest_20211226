package com.neppplus.finalproject_logictest_20211226

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.neppplus.finalproject_logictest_20211226.databinding.ActivityNumberBaseballGameBinding

class NumberBaseballGameActivity : BaseActivity() {

    lateinit var binding: ActivityNumberBaseballGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_number_baseball_game)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

    }
}