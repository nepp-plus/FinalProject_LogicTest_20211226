package com.neppplus.finalproject_logictest_20211226

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.neppplus.finalproject_logictest_20211226.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        binding.btnLottoSimulator.setOnClickListener {

            val myIntent = Intent(mContext, LottoSimulatorActivity::class.java)
            startActivity(myIntent)

        }

        binding.btnNumberBaseballGame.setOnClickListener {

            val myIntent = Intent(mContext, NumberBaseballGameActivity::class.java)
            startActivity(myIntent)

        }


    }

    override fun setValues() {

    }
}