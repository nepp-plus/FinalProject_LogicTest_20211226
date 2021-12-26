package com.neppplus.finalproject_logictest_20211226

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.neppplus.finalproject_logictest_20211226.databinding.ActivityLottoSimulatorBinding

class LottoSimulatorActivity : BaseActivity() {

    lateinit var binding: ActivityLottoSimulatorBinding

//    내 기입 번호 목록
    val myNumberList = arrayListOf( 6, 15, 23, 30, 35, 42 )

//    랜덤 당첨번호 목록 => 나중에 6개를 채워야함.
    val winNumberList = ArrayList<Int>()

//    당첨번호를 표시할 텍스트뷰 목록 => xml의 텍스트뷰 목록.
    val winNumberTxtList = ArrayList<TextView>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_lotto_simulator)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        binding.btnBuyLotto.setOnClickListener {

//            당첨번호 만들기 기능 실행.
            makeWinNumbers()

        }

    }

    fun makeWinNumbers() {

//        당첨 번호 생성 전에, 기존의 당첨번호는 모두 삭제.
        winNumberList.clear()

//      6번 반복 => 당첨번호 6개 생성.
        for (i  in  0 until 6) {

//            밑의 3가지 프로세스는 => 제대로 된 숫자가 나올때까지 무한 반복.
//            while => if와 문법이 동일한 수준임.

            while (true) {

//            1. 1~45 의 랜덤값 => Math.random()
//                =>  1 <= 랜덤값 * 45 + 1 < 46  (실수)

                val randomNum = (Math.random()*45 + 1).toInt()  // 실수 -> 정수로 변환 : 소수점 자리는 버림 처리.


//            2. 나온 랜덤값이 중복인가?
//                당첨번호 목록에, 지금뽑은 랜덤값이 이미 있는가? => 사용하면 안됨.
//                들어있지 않아야 => 사용 가능.

                val isDuplOk =  !winNumberList.contains(randomNum)

//            3. 중복이 아니면 (써도 된다면) winNumberList에 등록(추가)
//                => 다음 숫자 뽑으러 넘어가자.
//                => while무한반복 강제종료 => for문에 의해서 다음 숫자를 뽑으러 이동.

                if (isDuplOk) {
                    winNumberList.add( randomNum )

                    break // 제일 가까운 반복문 강제 종료.
                }

            }

        }

//        6개의 당첨번호를 로그로 확인 + 텍스트뷰에 반영.
        winNumberList.forEachIndexed { index, winNum ->

            winNumberTxtList[index].text = winNum.toString()

        }


    }

    override fun setValues() {

//        텍스트뷰 6개를 목록에 추가.
        winNumberTxtList.add( binding.txtWinNum1 )
        winNumberTxtList.add( binding.txtWinNum2 )
        winNumberTxtList.add( binding.txtWinNum3 )
        winNumberTxtList.add( binding.txtWinNum4 )
        winNumberTxtList.add( binding.txtWinNum5 )
        winNumberTxtList.add( binding.txtWinNum6 )

    }
}