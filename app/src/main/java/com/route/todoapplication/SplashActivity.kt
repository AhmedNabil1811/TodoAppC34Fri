package com.route.todoapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler()
            .postDelayed({
                gotoMainActivity()
            },2000)
    }

    private fun gotoMainActivity() {
        val intent = Intent(this,HomeActivity::class.java)
        startActivity(intent)
    }
}