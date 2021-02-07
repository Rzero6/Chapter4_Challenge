package com.example.chapter4_challenge

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.chapter4_challenge.databinding.ActivitySplashScreenBinding
import com.squareup.picasso.Picasso


class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Picasso.get().load("https://i.ibb.co/HC5ZPgD/splash-screen1.png").into(binding.textImageView)
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this,LandingActivity::class.java))
            finish()
        },3500)

    }
}