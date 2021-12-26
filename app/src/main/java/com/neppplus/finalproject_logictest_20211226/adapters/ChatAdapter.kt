package com.neppplus.finalproject_logictest_20211226.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.neppplus.finalproject_logictest_20211226.R
import com.neppplus.finalproject_logictest_20211226.datas.ChatData

class ChatAdapter(
    val mContext: Context,
    val mList: List<ChatData>
) : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    inner class ChatViewHolder(row: View) : RecyclerView.ViewHolder(row) {

        val txtCpuMessage = row.findViewById<TextView>(R.id.txtCpuMessage)
        val txtUserMessage = row.findViewById<TextView>(R.id.txtUserMessage)

        fun bind( data: ChatData ) {
//            실제 데이터 반영 함수

//            CPU가 말한 내용? 사용자 메세지 텍스트뷰 숨김, CPU 텍스트뷰는 보여주기.

            if (data.owner == "CPU") {

                txtUserMessage.visibility = View.GONE
                txtCpuMessage.visibility = View.VISIBLE

                txtCpuMessage.text = data.message

            }
            else {

                txtCpuMessage.visibility = View.GONE
                txtUserMessage.visibility = View.VISIBLE

                txtUserMessage.text = data.message

            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val row = LayoutInflater.from(mContext).inflate(R.layout.chat_list_item, parent, false)
        return ChatViewHolder(row)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {

        holder.bind( mList[position] )

    }

    override fun getItemCount() = mList.size

}