package com.example.testappe

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class log_in_op : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in_op)
        val restorepass = findViewById<TextView>(R.id.passrestore)
        restorepass.setOnClickListener(){
            val repass = Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/Nh7N2F-9ZbY/"))
            startActivity(repass)
        }
    }
}