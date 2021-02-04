package com.example.chapter4_challenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.chapter4_challenge.databinding.ActivityLandingBinding

class LandingActivity : AppCompatActivity() {
    private var binding: ActivityLandingBinding?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLandingBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val adapter=LandingPageAdapter(this)
        binding?.let {
            it.landingfragmentcontainer.adapter=adapter
            it.springDotsIndicator.setViewPager2(it.landingfragmentcontainer)
            it.landingfragmentcontainer.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }
            })
        }
    }
}