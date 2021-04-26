package com.example.testappe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ticket_detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticket_detail)
        findViewById<Button>(R.id.back_to_zayvki).setOnClickListener(){
            finish()
        }
    }
}
