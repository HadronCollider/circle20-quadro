package com.example.testappe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val loginop = findViewById<Button>(R.id.op_login)
        loginop.setOnClickListener() {
            val log_in_start = Intent(this, log_in_op::class.java)
            startActivity(log_in_start)
        }
        val loginuser = findViewById<Button>(R.id.user_login)
        loginuser.setOnClickListener() {
            val log_in_start = Intent(this, log_in_user::class.java)
            startActivity(log_in_start)
        }
    }
}