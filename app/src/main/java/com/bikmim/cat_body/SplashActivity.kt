package com.bikmim.cat_body

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bikmim.cat_body.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var sBinding: ActivitySplashBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(sBinding.root)

        // Splash -> Main Activity로 이동

        sBinding.splashStartBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}