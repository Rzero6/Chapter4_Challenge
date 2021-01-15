package com.example.chapter4_challenge

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.chapter4_challenge.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var player:String
    private lateinit var computer:String
    private var round:Int=0
    private var playerWinCount: Int=0
    private var choice= arrayOf("rock","paper","scissor")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.result.visibility=View.GONE

        binding.rockButton.setOnClickListener {
            Log.d("Player","choose rock")
            binding.rockButton.background=getDrawable(R.drawable.button_background_blue)
            binding.paperButton.isClickable=false
            binding.scissorButton.isClickable=false
            player="rock"
            computer=choice.random()
            comchoice(computer)
            Log.d("Coumputer","choose $computer")
            round++
            result(player,computer)
            binding.score.visibility=View.VISIBLE
        }
        binding.paperButton.setOnClickListener {
            Log.d("Player","choose paper")
            binding.paperButton.background=getDrawable(R.drawable.button_background_blue)
            binding.rockButton.isClickable=false
            binding.scissorButton.isClickable=false
            player="paper"
            computer=choice.random()
            comchoice(computer)
            Log.d("Coumputer","choose $computer")
            round++
            result(player,computer)
            binding.score.visibility=View.VISIBLE
        }
        binding.scissorButton.setOnClickListener {
            Log.d("Player","choose scissor")
            binding.scissorButton.background=getDrawable(R.drawable.button_background_blue)
            binding.paperButton.isClickable=false
            binding.rockButton.isClickable=false
            player="scissor"
            computer=choice.random()
            comchoice(computer)
            Log.d("Coumputer","choose $computer")
            round++
            result(player,computer)
            binding.score.visibility=View.VISIBLE
        }
        binding.resetButton.setOnClickListener {
            Log.d("Player","reset")
            binding.round.visibility=View.VISIBLE
            binding.round.text="ROUND : $round"
            reset()
        }

    }
    fun result(player:String,computer:String){

        if (player == computer) {
            binding.preresult.visibility= View.GONE
            binding.result.visibility=View.VISIBLE
            binding.result.text="Draw"
            binding.result.setTextColor(Color.WHITE)
            binding.result.setBackgroundColor(Color.BLUE)
            Log.d("Result","Draw")
        } else {
            if ((player == "rock" && computer == "scissor") || (player == "paper" && computer == "rock") || (player == "scissor" && computer == "paper")) {
                binding.preresult.visibility= View.GONE
                binding.result.visibility=View.VISIBLE
                binding.result.text="Player WIN"
                binding.result.setTextColor(Color.WHITE)
                binding.result.setBackgroundColor(Color.GREEN)
                playerWinCount++
                binding.score.text="SCORE: $playerWinCount"
                Log.d("Result","Win")
            } else {
                binding.preresult.visibility= View.GONE
                binding.result.visibility=View.VISIBLE
                binding.result.text="COM WIN"
                binding.result.setTextColor(Color.WHITE)
                binding.result.setBackgroundColor(Color.RED)
                Log.d("Result","Lose")
            }

        }
    }
    fun reset() {
        player=""
        computer=""
        binding.rockButton.setBackgroundColor(Color.TRANSPARENT)
        binding.paperButton.setBackgroundColor(Color.TRANSPARENT)
        binding.scissorButton.setBackgroundColor(Color.TRANSPARENT)
        binding.rockView.setBackgroundColor(Color.TRANSPARENT)
        binding.paperView.setBackgroundColor(Color.TRANSPARENT)
        binding.scissorView.setBackgroundColor(Color.TRANSPARENT)
        binding.paperButton.isClickable=true
        binding.scissorButton.isClickable=true
        binding.rockButton.isClickable=true
        binding.result.visibility=View.GONE
        binding.preresult.visibility= View.VISIBLE
    }
    fun comchoice(computer: String){
        if (computer=="rock") {
            binding.rockView.background=getDrawable(R.drawable.button_background_red)
        }
        if (computer=="paper") {
            binding.paperView.background=getDrawable(R.drawable.button_background_red)
        }
        if (computer=="scissor") {
            binding.scissorView.background=getDrawable(R.drawable.button_background_red)
        }
    }

}