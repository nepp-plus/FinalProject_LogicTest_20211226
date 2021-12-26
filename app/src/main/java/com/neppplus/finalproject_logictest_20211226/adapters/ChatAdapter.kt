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