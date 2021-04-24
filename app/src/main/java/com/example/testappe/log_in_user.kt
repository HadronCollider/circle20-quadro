package com.example.testappe


import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject


//"http://gpn.unmanned.ru/api/login"

//import com.example.testappe.R.layout.activity_log_in_user

var TOKEN = ""

class log_in_user : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?)   {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in_user)
        findViewById<TextView>(R.id.passrestore).setOnClickListener()
        {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://nu-kak-tam-s-dengami.sk8er.name/")))
        }
        findViewById<Button>(R.id.log_in_user).setOnClickListener()
        {
            val username = findViewById<TextView>(R.id.user_mail_user).text
            var userPassword = findViewById<TextView>(R.id.user_pass_user).text
            var username1 =  findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.outlinedTextField)
            var userpass1 =  findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.outlinedTextField1)
            if ((userPassword.isBlank())||(username.isBlank()))
            {
                userpass1.error = "Не заполнено поле логин и/или пароль"
                username1.error = " "
            }else{
                val client = OkHttpClient()
                val request = POST(username.toString(), userPassword.toString())
                userpass1.error = null
                username1.error = null
                Thread {

                    val res1 = client.newCall(request).execute()
                    val jsonObject = JSONObject(res1.body?.string())

                    val code = res1.code.toString()
                    if (code != "500") {
                        val status = jsonObject.get("status")
                        TOKEN = jsonObject.get("token").toString()
                        Log.d("mypopo", TOKEN)
                        if (status == "success") {
                            val newIntent = Intent(this, mytickets_user::class.java)
                            val request2 = GET(TOKEN)
                            val res2 = client.newCall(request2).execute()
                            val jsonObject2 = JSONObject(res2.body?.string())
                            val user = jsonObject2.get("user").toString()
                            newIntent.putExtra("json", user)
                            runOnUiThread {
                                userpass1.error = null
                                username1.error = null
                            }
                            startActivity(newIntent)
                        }
                    }else{
                        runOnUiThread {
                            userpass1.error = "Непривльный логин и/или пароль"
                            username1.error = " "
                        }
                    }
                    // Log.d("ok_http_test", "${res1.code.toString()}, ${res1.toString()},${res1.body?.string()}")
                }.start()
            }
        }
    }
}