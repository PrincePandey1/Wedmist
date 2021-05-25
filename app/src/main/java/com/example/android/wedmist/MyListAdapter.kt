package com.example.android.wedmist

import android.app.Activity
import android.content.Context
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.custom_list.view.*

class ListAdapter (private val context: Context, private val items:ArrayList<UserModelClass>):RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
                LayoutInflater.from(context).inflate(R.layout.custom_list, parent,false))

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val item = items.get(position)

        holder.tv_Name.text = item.userName
        holder.tv_Email.text = item.userEmail
        holder.tv_password.text = item.userPassword

        if(position % 2 == 0){
            holder.tv_main.setBackgroundColor(
                    ContextCompat.getColor(context,R.color.colorPrimary))
        }else{
            holder.tv_main.setBackgroundColor(
                    ContextCompat.getColor(context,R.color.white))
        }


    }

    override fun getItemCount(): Int {
        return   items.size
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val tv_Name = itemView.textViewName
        val  tv_Email = itemView.textViewEmail
        val   tv_password  = itemView.textViewPassword
        val  tv_main = itemView.llMain



    }
}