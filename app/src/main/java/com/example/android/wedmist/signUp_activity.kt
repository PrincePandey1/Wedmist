package com.example.android.wedmist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up_activity.*
import java.io.DataInputStream
import java.sql.DatabaseMetaData

class signUp_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_activity)

       window.setFlags(
               WindowManager.LayoutParams.FLAG_FULLSCREEN,
               WindowManager.LayoutParams.FLAG_FULLSCREEN,
       )
        supportActionBar()

        btn_sign_up_logo.setOnClickListener{

            val name = et_name.text.toString()
            val email = et_email.text.toString()
            val password = et_password_signUp.text.toString()

            val dataBaseHandler : DatabaseHandler = DatabaseHandler(this)

            if(!name.isEmpty() && !email.isEmpty() && !password.isEmpty()){

                val status = dataBaseHandler.addUser(UserModelClass(name,email,password))

                if(status > -1){
                    Toast.makeText(this,"Record save",Toast.LENGTH_LONG).show()

                    et_name.text?.clear()
                    et_email.text?.clear()
                    et_password_signUp.text?.clear()

                }else{
                    Toast.makeText(this,"Please fill up the credentials",Toast.LENGTH_LONG).show()
                }
            }


        }
    }

   private fun supportActionBar(){

       setSupportActionBar(toolbar_sign_up_activity)

       val actionBar = supportActionBar
      if(actionBar != null){
          actionBar.setDisplayHomeAsUpEnabled(true)
          actionBar.setHomeAsUpIndicator(R.drawable.ic_black)
      }
       toolbar_sign_up_activity.setNavigationOnClickListener {
           onBackPressed()
       }

   }





    }
