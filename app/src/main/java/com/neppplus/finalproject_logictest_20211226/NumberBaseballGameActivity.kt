package com.neppplus.finalproject_logictest_20211226

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.neppplus.finalproject_logictest_20211226.adapters.ChatAdapter
import com.neppplus.finalproject_logictest_20211226.databinding.ActivityNumberBaseballGameBinding
import com.neppplus.finalproject_logictest_20211226.datas.ChatData

class NumberBaseballGameActivity : BaseActivity() {

    lateinit var binding: ActivityNumberBaseballGameBinding

    val mChatList = ArrayList<ChatData>()

    lateinit var mAdapter : ChatAdapter

//    컴퓨터가 낸 3자리 문제를 담아둘 ArrayList
    val cpuNumbers = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_number_baseball_game)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        binding.btnSend.setOnClickListener {

            val inputMessage =  binding.edtNumber.text.toString()

//            내가 입력한 내용으로 채팅 화면에 추가

            val myChatData = ChatData( "USER", inputMessage  )

            mChatList.add( myChatData )

//            어댑터에게 새로고침 처리
            mAdapter.notifyDataSetChanged()

//            숫자 입력칸 비워주기.
            binding.edtNumber.setText("")

//            ?S ?B 계산해서 알려주기
            checkStrikeAndBall(inputMessage)

        }

    }

    fun checkStrikeAndBall( inputMessage: String ) {

//        String -> 입력 문구를 3칸 목록으로 변경.  "123" -> 123 -> [1, 2, 3]

        val inputNumber =  inputMessage.toInt()

//        123 -> [1, 2, 3] 목록으로.
//        첫번째로 추가 : 100의 자리.
//        두번째로 추가 : 10의 자리.
//        세번째로 추가 : 1의 자리.

        val myNumbers = ArrayList<Int>()

        myNumbers.add( inputNumber / 100 ) // 123 => 1 추출? 정수 / 정수 : 결과도 정수 (소수점 버림) => 123 / 100 = 1
        myNumbers.add( inputNumber / 10 % 10 ) // 123 => 2 추출? 123 -> 12로 변환 (10으로 나눈 몫) -> 1의 자리?
        myNumbers.add( inputNumber % 10 ) // 123 => 3 추출? 10으로 나눈 나머지? 1의 자리.

//        분리 확인용 로그
        for (num in myNumbers) {
            Log.d("내 숫자", num.toString())
        }

//        내 숫자 3개 / CPU 숫자 3개 => s / b 갯수 판별
        var strikeCount = 0
        var ballCount = 0

//        반복 검사 => 실제 데이터 + 위치값

        myNumbers.forEachIndexed { myIndex, myNum ->

//            내 숫자 하나당 => CPU 숫자 세개 검사.

            cpuNumbers.forEachIndexed { cpuIndex, cpuNum ->

//                S/B => 숫자는 같아야 판단.
                if (myNum == cpuNum) {
//                    같은 숫자 발견!
//                    추가 질문. => 위치도 같은가? 같으면 S / 다르면 B
                    if (myIndex == cpuIndex) {
                        strikeCount++
                    }
                    else {
//                        위치는 다르지만, 숫자는 같다. B
                        ballCount++
                    }

                }

            }

        }

//        ?S ?B 모두 구해냄
        Log.d("스트라이크", strikeCount.toString())
        Log.d("볼", ballCount.toString())

    }

    override fun setValues() {

        makeCpuNumbers()

        mChatList.add( ChatData("CPU", "숫자 야구게임에 오신것을 환영합니다.") )
        mChatList.add( ChatData("CPU", "3자리 숫자로 문제가 생성되었습니다.") )
        mChatList.add( ChatData("CPU", "밑의 입력칸을 이용해 3자리 숫자를 맞춰주세요.") )


        mAdapter = ChatAdapter(mContext, mChatList)
        binding.chattingRecyclerView.adapter = mAdapter
        binding.chattingRecyclerView.layoutManager = LinearLayoutManager(mContext)

    }

//    컴퓨터가 3자리 문제 출제 함수.

    fun makeCpuNumbers() {

//        3개의 숫자를 문제로.

        for (i  in  0 until 3) {

//            써도 되는 숫자가 나올때까지 무한반복 => 랜덤숫자 추출.
            while (true) {

//                1~9의 랜덤값 추출.
                val randomNum = (Math.random() * 9 + 1).toInt()  // 1 ~ 9 사이의 랜덤값.

//                cpuNumbers에 이미 나와있나?
                val isDuplOk =  !cpuNumbers.contains(randomNum)

                if (isDuplOk) {
                    cpuNumbers.add( randomNum )
//                    무한반복 종료 => 다음 숫자 뽑으러.
                    break
                }

            }

        }

//        문제 확인용 로그
        for (num in cpuNumbers) {
            Log.d("문제숫자", num.toString())
        }

    }

}