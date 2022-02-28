package com.example.recyclerviewdemo.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewdemo.R
import kotlinx.android.synthetic.main.item_custom_row.view.*

class ItemAdapters(val context :Context,  val items :ArrayList<DataModel>)
    :RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    companion object
    {
        const val PRIVATE_GROUP :String = "Nhóm Kín"
        const val PUBLIC_GROUP :String = "Nhóm Mở"
        const val CLOSE_GROUP :String = "Nhóm Đóng"
        const val NEW_POSTS_10 :String = "10 New Posts"
        const val NEW_POSTS_20 :String = "20 New Posts"

        const val MEMBER :String = "Followers"
        const val K_MEMBER :String = "K Followers"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_custom_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]

        if(holder is ViewHolder)
        {
            holder.imgViewItem.setImageResource(item.imgGroup)
            holder.groupName.text = item.name
            holder.groupMember.text = item.numOfMem.toString()
            holder.groupStatus.text = item.currentStatus
            holder.groupActivity.text = item.currentActivity
            if(item.numOfMem.toDouble() >= 1000)
            {
                holder.groupMember.text = "${(item.numOfMem.div(1000)).toString()}" + "$K_MEMBER"
            }
            else
            {
                holder.groupMember.text = "${item.numOfMem.toString()}" + " $MEMBER"
            }
            when(item.currentStatus)
            {
                PRIVATE_GROUP-> {
                    holder.groupStatus.setTextColor(ContextCompat.getColor(context,R.color.private_group))
                }
                PUBLIC_GROUP -> {
                    holder.groupStatus.setTextColor(ContextCompat.getColor(context,R.color.public_group))
                }
                CLOSE_GROUP -> {
                    holder.groupStatus.setTextColor(ContextCompat.getColor(context,R.color.closed_group))
                }
            }
        }
    }


    override fun getItemCount(): Int {
        return items.size
    }
    class ViewHolder(view :View) :RecyclerView.ViewHolder(view)
    {
        //Holds the Text View
        val cardViewItem :CardView = view.cardViewItem
        var imgViewItem :ImageView = view.imgViewItem
        var groupName :TextView = view.txtViewGroupName
        var groupMember  :TextView = view.txtViewGroupMember
        var groupActivity :TextView = view.txtViewGroupActivity
        var groupStatus :TextView = view.txtViewGroupStatus
    }
}

