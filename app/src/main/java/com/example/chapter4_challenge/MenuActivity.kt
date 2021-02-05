package com.example.chapter4_challenge

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.chapter4_challenge.databinding.ActivityMenuBinding
import com.google.android.material.snackbar.Snackbar

class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding
    var check: Boolean = false
    var mode: Int = 0

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val playername = intent.getStringExtra("playername")
        val intent = Intent(this, MainActivity::class.java)
        val username = playername
        binding.pvptext.text = "$username vs Player"
        binding.pvetext.text = "$username vs CPU"
        Snackbar.make(binding.root, "Welcome $playername", Snackbar.LENGTH_LONG)
            .setAction("Close") {

            }.show()

        binding.pvp.setOnClickListener {
            mode = 1
            binding.pvp.background = getDrawable(R.drawable.button_background_blue)
            binding.pvptext.setTextColor(Color.WHITE)
            binding.pvetext.setTextColor(Color.BLACK)
            binding.pvp.isClickable = false
            binding.pve.isClickable = true
            binding.pve.setBackgroundColor(Color.TRANSPARENT)
            binding.player2input.visibility = View.VISIBLE
            check = true
        }
        binding.pve.setOnClickListener {
            mode = 2
            binding.pve.background = getDrawable(R.drawable.button_background_red)
            binding.pvetext.setTextColor(Color.WHITE)
            binding.pvptext.setTextColor(Color.BLACK)
            binding.pve.isClickable = false
            binding.pvp.isClickable = true
            binding.pvp.setBackgroundColor(Color.TRANSPARENT)
            binding.player2input.visibility = View.GONE
            check = true
        }



        binding.playbutton.setOnClickListener {
            if (check == true) {
                val player2 = binding.player2Name.text.toString().trim()
                if (player2.isEmpty() && mode==1) {
                    Toast.makeText(this, "Input Player 2 Name!", Toast.LENGTH_SHORT).show()
                } else {
                    intent.putExtra("player2name", player2)
                    intent.putExtra("username", username)
                    intent.putExtra("mode", mode)
                    startActivity(intent)
                }
            } else {
                Toast.makeText(this, "Choose Your Opponent!", Toast.LENGTH_SHORT).show()
            }

        }
    }
}