package com.example.chapter4_challenge

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
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
                Toast.makeText(this,"$username picked $player\n$player2name picked $computer",Toast.LENGTH_LONG).show()
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
                Toast.makeText(this,"$username picked $player\n$player2name picked $computer",Toast.LENGTH_LONG).show()
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
                Toast.makeText(this,"$username picked $player\n$player2name picked $computer",Toast.LENGTH_LONG).show()
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
                    Toast.makeText(this,"$username picked $player\n$player2name picked $computer",Toast.LENGTH_LONG).show()
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
                    Toast.makeText(this,"$username picked $player\n$player2name picked $computer",Toast.LENGTH_LONG).show()
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
                    Toast.makeText(this,"$username picked $player\n$player2name picked $computer",Toast.LENGTH_LONG).show()
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
                    Toast.makeText(this,"$username picked $player\n$player2name picked $computer",Toast.LENGTH_LONG).show()
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
                    Toast.makeText(this,"$username picked $player\n$player2name picked $computer",Toast.LENGTH_LONG).show()
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
                    Toast.makeText(this,"$username picked $player\n$player2name picked $computer",Toast.LENGTH_LONG).show()
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
                    Toast.makeText(this,"$username picked $player\n$player2name picked $computer",Toast.LENGTH_LONG).show()
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
                    Toast.makeText(this,"$username picked $player\n$player2name picked $computer",Toast.LENGTH_LONG).show()
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
                    Toast.makeText(this,"$username picked $player\n$player2name picked $computer",Toast.LENGTH_LONG).show()
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
        binding.closeButton.setOnClickListener {
            val intent=Intent(this,MenuActivity::class.java)
            intent.putExtra("playername",username)
            startActivity(intent)
        }

    }

    fun result(player: String, computer: String, username: String, player2name: String) {
        if (player == computer) {
            val result="Draw!"
            val score="$playerWinCount - $player2WinCount"
            resultDialog(result,score,username)
            Log.d("Result", "Draw")
        } else {
            if ((player == "rock" && computer == "scissor") || (player == "paper" && computer == "rock") || (player == "scissor" && computer == "paper")) {
                playerWinCount++
                val result="$username \nWON!"
                val score="$playerWinCount - $player2WinCount"
                resultDialog(result,score,username)
                Log.d("Result", "Win")
            } else {
                player2WinCount++
                val result="$player2name \nWON!"
                val score="$playerWinCount - $player2WinCount"
                resultDialog(result,score,username)
                Log.d("Result", "Lose")
            }

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

    fun resultDialog(result: String,score: String,username: String) {
        val builder = AlertDialog.Builder(this)
        val view = ResultLayoutBinding.inflate(layoutInflater)
        builder.setView(view.root)
        val dialog=builder.create()
        view.matchResult.text=result
        view.scoreScreen.text=score
        view.playagainButton.setOnClickListener {
            reset(username)
            dialog.dismiss()
        }
        view.menuButton.setOnClickListener {
            val intent=Intent(this,MenuActivity::class.java)
            intent.putExtra("playername",username)
            startActivity(intent)
        }
        dialog.setCancelable(false)
        dialog.show()
    }


}