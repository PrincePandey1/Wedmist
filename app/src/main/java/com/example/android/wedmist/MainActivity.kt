package com.example.android.wedmist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,  //Inorder to hide status bar
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
        )

        btn_sign_in_intro.setOnClickListener {
            startActivity(Intent(this,sigin_activity::class.java))
        }

        btn_sign_up_intro.setOnClickListener {
            startActivity(Intent(this,signUp_activity::class.java))
        }


    }



}