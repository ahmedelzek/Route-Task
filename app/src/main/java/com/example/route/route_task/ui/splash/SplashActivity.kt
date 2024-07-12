package com.example.route.route_task.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.route.route_task.R
import com.example.route.route_task.ui.product.ProductActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startProductActivity()
    }
    private fun startProductActivity() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@SplashActivity, ProductActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }

}