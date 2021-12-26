package com.neppplus.finalproject_logictest_20211226.datas

class ChatData(
    var owner: String,  // 'CPU' or 'USER' 둘중 하나로 담아서, 누가 말한건지 기록.
    var message: String, // 실제 보낸 내용.
) {
}