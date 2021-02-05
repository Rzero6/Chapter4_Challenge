package com.example.chapter4_challenge

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.chapter4_challenge.databinding.ActivityMainBinding
import com.example.chapter4_challenge.databinding.ResultLayoutBinding


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var player: String
    private lateinit var computer: String
    private var round: Int = 1
    private var playerWinCount: Int = 0
    private var choice = arrayOf("rock", "paper", "scissor")

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val username = intent.getStringExtra("username")
        val mode = intent.getIntExtra("mode", 0)
        val player2 = intent.getStringExtra("player2name")
        binding.idPlayer.text = username
        binding.result.visibility = View.GONE


        //PVE
        if (mode == 2) {
            binding.rockButton.setOnClickListener {
                Log.d("Player", "choose rock")
                binding.rockButton.background = getDrawable(R.drawable.button_background_blue)
                binding.paperButton.isClickable = false
                binding.scissorButton.isClickable = false
                player = "rock"
                computer = choice.random()
                comchoice(computer)
                Log.d("Coumputer", "choose $computer")
                round++
                result(player, computer)
                binding.score.visibility = View.VISIBLE
            }
            binding.paperButton.setOnClickListener {
                Log.d("Player", "choose paper")
                binding.paperButton.background = getDrawable(R.drawable.button_background_blue)
                binding.rockButton.isClickable = false
                binding.scissorButton.isClickable = false
                player = "paper"
                computer = choice.random()
                comchoice(computer)
                Log.d("Coumputer", "choose $computer")
                round++
                result(player, computer)
                binding.score.visibility = View.VISIBLE
            }
            binding.scissorButton.setOnClickListener {
                Log.d("Player", "choose scissor")
                binding.scissorButton.background = getDrawable(R.drawable.button_background_blue)
                binding.paperButton.isClickable = false
                binding.rockButton.isClickable = false
                player = "scissor"
                computer = choice.random()
                comchoice(computer)
                Log.d("Coumputer", "choose $computer")
                round++
                result(player, computer)
                binding.score.visibility = View.VISIBLE
            }
        }

        //PVP
        if (mode == 1) {
            binding.idComputer.text = player2
            binding.rockButton.setOnClickListener {
                Log.d("Player", "choose rock")
                binding.paperButton.isClickable = false
                binding.scissorButton.isClickable = false
                AlertDialog.Builder(this).setTitle("$player2's turn").setMessage("$player2 pick your hand").setCancelable(true).show()
                binding.rockView.setOnClickListener {
                    binding.rockButton.background = getDrawable(R.drawable.button_background_blue)
                    binding.rockView.background = getDrawable(R.drawable.button_background_red)
                    binding.paperView.isClickable = false
                    binding.scissorView.isClickable = false
                    player = "rock"
                    computer = "rock"
                    Log.d("Coumputer", "choose $computer")
                    round++
                    result(player, computer)
                    binding.score.visibility = View.VISIBLE
                }
                binding.paperView.setOnClickListener {
                    binding.rockButton.background = getDrawable(R.drawable.button_background_blue)
                    binding.paperView.background = getDrawable(R.drawable.button_background_red)
                    binding.rockView.isClickable = false
                    binding.scissorView.isClickable = false
                    player = "rock"
                    computer = "paper"
                    Log.d("Coumputer", "choose $computer")
                    round++
                    result(player, computer)
                    binding.score.visibility = View.VISIBLE
                }
                binding.scissorView.setOnClickListener {
                    binding.rockButton.background = getDrawable(R.drawable.button_background_blue)
                    binding.scissorView.background = getDrawable(R.drawable.button_background_red)
                    binding.paperView.isClickable = false
                    binding.rockView.isClickable = false
                    player = "rock"
                    computer = "scissor"
                    Log.d("Coumputer", "choose $computer")
                    round++
                    result(player, computer)
                    binding.score.visibility = View.VISIBLE
                }
            }
            binding.paperButton.setOnClickListener {
                Log.d("Player", "choose paper")
                binding.rockButton.isClickable = false
                binding.scissorButton.isClickable = false
                AlertDialog.Builder(this).setTitle("$player2's turn").setMessage("$player2 pick your hand").setCancelable(true).show()
                binding.rockView.setOnClickListener {
                    binding.paperButton.background = getDrawable(R.drawable.button_background_blue)
                    binding.rockView.background = getDrawable(R.drawable.button_background_red)
                    binding.paperView.isClickable = false
                    binding.scissorView.isClickable = false
                    player = "paper"
                    computer = "rock"
                    Log.d("Coumputer", "choose $computer")
                    round++
                    result(player, computer)
                    binding.score.visibility = View.VISIBLE
                }

                binding.paperView.setOnClickListener {
                    binding.paperButton.background = getDrawable(R.drawable.button_background_blue)
                    binding.paperView.background = getDrawable(R.drawable.button_background_red)
                    binding.scissorView.isClickable = false
                    binding.rockView.isClickable = false
                    player = "paper"
                    computer = "paper"
                    Log.d("Coumputer", "choose $computer")
                    round++
                    result(player, computer)
                    binding.score.visibility = View.VISIBLE
                }
                binding.scissorView.setOnClickListener {
                    binding.paperButton.background = getDrawable(R.drawable.button_background_blue)
                    binding.scissorView.background = getDrawable(R.drawable.button_background_red)
                    binding.paperView.isClickable = false
                    binding.rockView.isClickable = false
                    player = "paper"
                    computer = "scissor"
                    Log.d("Coumputer", "choose $computer")
                    round++
                    result(player, computer)
                    binding.score.visibility = View.VISIBLE
                }
            }
            binding.scissorButton.setOnClickListener {
                Log.d("Player", "choose scissor")
                binding.paperButton.isClickable = false
                binding.rockButton.isClickable = false
                AlertDialog.Builder(this).setTitle("$player2's turn").setMessage("$player2 pick your hand").setCancelable(true).show()
                binding.rockView.setOnClickListener {
                    binding.scissorButton.background =
                        getDrawable(R.drawable.button_background_blue)
                    binding.rockView.background = getDrawable(R.drawable.button_background_red)
                    binding.paperView.isClickable = false
                    binding.scissorView.isClickable = false
                    player = "scissor"
                    computer = "rock"
                    Log.d("Coumputer", "choose $computer")
                    round++
                    result(player, computer)
                    binding.score.visibility = View.VISIBLE
                }
                binding.paperView.setOnClickListener {
                    binding.scissorButton.background =
                        getDrawable(R.drawable.button_background_blue)
                    binding.paperView.background = getDrawable(R.drawable.button_background_red)
                    binding.scissorView.isClickable = false
                    binding.rockView.isClickable = false
                    player = "scissor"
                    computer = "paper"
                    Log.d("Coumputer", "choose $computer")
                    round++
                    result(player, computer)
                    binding.score.visibility = View.VISIBLE
                }
                binding.scissorView.setOnClickListener {
                    binding.scissorButton.background =
                        getDrawable(R.drawable.button_background_blue)
                    binding.scissorView.background = getDrawable(R.drawable.button_background_red)
                    binding.paperView.isClickable = false
                    binding.rockView.isClickable = false
                    player = "scissor"
                    computer = "scissor"
                    Log.d("Coumputer", "choose $computer")
                    round++
                    result(player, computer)
                    binding.score.visibility = View.VISIBLE
                }
            }
        }
        binding.resetButton.setOnClickListener {
            Log.d("Player", "reset")
            binding.round.visibility = View.VISIBLE
            binding.round.text = "ROUND : $round"
            reset()
        }

    }

    fun result(player: String, computer: String) {

        if (player == computer) {
            binding.preresult.visibility = View.GONE
            binding.result.visibility = View.VISIBLE
            binding.result.text = "Draw"
            binding.result.setTextColor(Color.WHITE)
            binding.result.setBackgroundColor(Color.BLUE)
            Log.d("Result", "Draw")
        } else {
            if ((player == "rock" && computer == "scissor") || (player == "paper" && computer == "rock") || (player == "scissor" && computer == "paper")) {
                binding.preresult.visibility = View.GONE
                binding.result.visibility = View.VISIBLE
                binding.result.text = "Player WIN"
                binding.result.setTextColor(Color.WHITE)
                binding.result.setBackgroundColor(Color.GREEN)
                playerWinCount++
                binding.score.text = "SCORE: $playerWinCount"
                Log.d("Result", "Win")
            } else {
                binding.preresult.visibility = View.GONE
                binding.result.visibility = View.VISIBLE
                binding.result.text = "COM WIN"
                binding.result.setTextColor(Color.WHITE)
                binding.result.setBackgroundColor(Color.RED)
                Log.d("Result", "Lose")
            }

        }
    }

    fun reset() {
        player = ""
        computer = ""
        binding.rockButton.setBackgroundColor(Color.TRANSPARENT)
        binding.paperButton.setBackgroundColor(Color.TRANSPARENT)
        binding.scissorButton.setBackgroundColor(Color.TRANSPARENT)
        binding.rockView.setBackgroundColor(Color.TRANSPARENT)
        binding.paperView.setBackgroundColor(Color.TRANSPARENT)
        binding.scissorView.setBackgroundColor(Color.TRANSPARENT)
        binding.paperButton.isClickable = true
        binding.scissorButton.isClickable = true
        binding.rockButton.isClickable = true
        binding.result.visibility = View.GONE
        binding.preresult.visibility = View.VISIBLE
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun comchoice(computer: String) {
        if (computer == "rock") {
            binding.rockView.background = getDrawable(R.drawable.button_background_red)
        }
        if (computer == "paper") {
            binding.paperView.background = getDrawable(R.drawable.button_background_red)
        }
        if (computer == "scissor") {
            binding.scissorView.background = getDrawable(R.drawable.button_background_red)
        }
    }

}