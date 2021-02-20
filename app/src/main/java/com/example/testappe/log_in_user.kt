package com.example.testappe

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class log_in_user : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in_user)

        val restorepass = findViewById<TextView>(R.id.passrestore)
        restorepass.setOnClickListener(){
            val repass = Intent(Intent.ACTION_VIEW, Uri.parse("https://nu-kak-tam-s-dengami.sk8er.name/"))
            startActivity(repass)
        }
        val logbut = findViewById<Button>(R.id.log_in)
        logbut.setOnClickListener(){
            val tickets = Intent(this, mytickets:: class.java)
            startActivity(tickets)
        }

    }
}
