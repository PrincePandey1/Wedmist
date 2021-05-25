package com.example.android.wedmist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_sign_in_activity.*
import kotlinx.android.synthetic.main.activity_sign_up_activity.*
import kotlinx.android.synthetic.main.activity_sign_up_activity.toolbar_sign_up_activity
import kotlinx.android.synthetic.main.listview.*

class sigin_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in_activity)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
        )

        supportActionBar()


    }
    private fun supportActionBar(){

        setSupportActionBar(toolbar_sign_in_activity)

        val actionBar = supportActionBar
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_black)
        }
        toolbar_sign_in_activity.setNavigationOnClickListener {
            onBackPressed()
        }

        btn_sign_in_logo.setOnClickListener {


            val databaseHandler = DatabaseHandler(this)
            val user: List<UserModelClass> = databaseHandler.viewUser()

            val userArrayName = Array<String>(user.size){"null"}
            val userArrayEmail = Array<String>(user.size){"null"}
            val userArrayPassword = Array<String>(user.size){"null"}

            var index = 0
            for(e in user){

                userArrayName[index] = e.userName
                userArrayEmail[index] = e.userEmail
                userArrayPassword[index] = e.userPassword
                index++
            }

            val myListAdapter = MyListAdapter(this, userArrayName, userArrayPassword, userArrayEmail)
            listView.adapter = myListAdapter
        }

    }


}

