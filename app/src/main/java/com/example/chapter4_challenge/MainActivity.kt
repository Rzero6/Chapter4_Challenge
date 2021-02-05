package com.example.chapter4_challenge

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
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
    private lateinit var bindingresult: ResultLayoutBinding
    private lateinit var player: String
    private lateinit var computer: String
    private var round: Int = 1
    private var playerWinCount: Int = 0
    private var player2WinCount: Int = 0
    private var choice = arrayOf("rock", "paper", "scissor")

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val username = intent.getStringExtra("username").toString()
        val mode = intent.getIntExtra("mode", 0)
        var player2name = intent.getStringExtra("player2name").toString()
        binding.idPlayer.text = username
        if (mode==2) {
            player2name = "CPU"
        }else {
            binding.idComputer.text = player2name
        }
        //PVE
        AlertDialog.Builder(this).setTitle("$username's turn").setMessage("$username pick your hand").setCancelable(true).show()
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
                result(player, computer, username, player2name)
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
                result(player, computer, username, player2name)
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
                result(player, computer, username, player2name)
            }
        }

        //PVP
        if (mode == 1) {
            binding.rockButton.setOnClickListener {
                Log.d("Player", "choose rock")
                binding.paperButton.isClickable = false
                binding.scissorButton.isClickable = false
                AlertDialog.Builder(this).setTitle("$player2name's turn").setMessage("$player2name pick your hand").setCancelable(true).show()
                binding.rockView.setOnClickListener {
                    binding.rockButton.background = getDrawable(R.drawable.button_background_blue)
                    binding.rockView.background = getDrawable(R.drawable.button_background_red)
                    binding.paperView.isClickable = false
                    binding.scissorView.isClickable = false
                    player = "rock"
                    computer = "rock"
                    Log.d("Coumputer", "choose $computer")
                    round++
                    result(player, computer, username, player2name)
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
                    result(player, computer, username, player2name)
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
                    result(player, computer, username, player2name)
                }
            }
            binding.paperButton.setOnClickListener {
                Log.d("Player", "choose paper")
                binding.rockButton.isClickable = false
                binding.scissorButton.isClickable = false
                AlertDialog.Builder(this).setTitle("$player2name's turn").setMessage("$player2name pick your hand").setCancelable(true).show()
                binding.rockView.setOnClickListener {
                    binding.paperButton.background = getDrawable(R.drawable.button_background_blue)
                    binding.rockView.background = getDrawable(R.drawable.button_background_red)
                    binding.paperView.isClickable = false
                    binding.scissorView.isClickable = false
                    player = "paper"
                    computer = "rock"
                    Log.d("Coumputer", "choose $computer")
                    round++
                    result(player, computer, username, player2name)
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
                    result(player, computer, username, player2name)
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
                    result(player, computer, username, player2name)
                }
            }
            binding.scissorButton.setOnClickListener {
                Log.d("Player", "choose scissor")
                binding.paperButton.isClickable = false
                binding.rockButton.isClickable = false
                AlertDialog.Builder(this).setTitle("$player2name's turn").setMessage("$player2name pick your hand").setCancelable(true).show()
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
                    result(player, computer, username, player2name)
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
                    result(player, computer, username, player2name)
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
                    result(player, computer, username, player2name)
                }
            }
        }

        binding.resetButton.setOnClickListener {
            Log.d("Player", "reset")
            binding.round.visibility = View.VISIBLE
            binding.round.text = "ROUND : $round"
            reset(username)
        }

    }

    fun result(player: String, computer: String, username: String, player2name: String) {
        bindingresult= ResultLayoutBinding.inflate(layoutInflater)
        val resultDialog = AlertDialog.Builder(this)
        resultDialog.setView(bindingresult.root)
        val intent=Intent(this,MenuActivity::class.java)
        val dialog=resultDialog.create()
        if (player == computer) {
            bindingresult.matchResult.text="DRAW!"
            bindingresult.scoreScreen.text="$playerWinCount - $player2WinCount"
            bindingresult.matchResult.setTextColor(Color.BLACK)
            resultDialog.show()
            Log.d("Result", "Draw")
        } else {
            if ((player == "rock" && computer == "scissor") || (player == "paper" && computer == "rock") || (player == "scissor" && computer == "paper")) {
                playerWinCount++
                bindingresult.matchResult.text="$username \nWON!"
                bindingresult.scoreScreen.text="$playerWinCount - $player2WinCount"
                bindingresult.matchResult.setTextColor(Color.BLUE)
                resultDialog.show()
                Log.d("Result", "Win")
            } else {
                player2WinCount++
                bindingresult.matchResult.text="$player2name \nWON!"
                bindingresult.scoreScreen.text="$playerWinCount - $player2WinCount"
                bindingresult.matchResult.setTextColor(Color.RED)
                resultDialog.show()
                Log.d("Result", "Lose")
            }

        }
        bindingresult.playagainButton.setOnClickListener {
            dialog.dismiss()
            reset(username)
        }
        bindingresult.menuButton.setOnClickListener {
            dialog.dismiss()
            reset(username)
            intent.putExtra("playername",username)
            startActivity(intent)
        }
    }


    fun reset(username: String) {
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
        AlertDialog.Builder(this).setTitle("$username's turn").setMessage("$username pick your hand").setCancelable(true).show()
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