package com.example.android.wedmist

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView


class MyListAdapter(private val context: Activity, private val name: Array<String>, private val email: Array<String>, private val password: Array<String>)
    : ArrayAdapter<String>(context, R.layout.custom_list, name) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.custom_list, null, true)

        val nameText = rowView.findViewById(R.id.textViewName) as TextView
        val EmailText = rowView.findViewById(R.id.textViewEmail) as TextView
        val passwordText = rowView.findViewById(R.id.textViewPassword) as TextView

        nameText.text = "Id: ${name[position]}"
        EmailText.text = "Name: ${email[position]}"
        passwordText.text = "Email: ${password[position]}"
        return rowView
    }
}