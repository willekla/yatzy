package com.example.diceroller

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.diceroller.com.example.diceroller.Player
import com.example.diceroller.databinding.ActivityMainBinding


/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var count = 1;
    private var resTxt = ""

    private val t1 = Dice()
    private val t2 = Dice()
    private val t3 = Dice()
    private val t4 = Dice()
    private val t5 = Dice()
    private val yatzy = Yatzy()
    private var player = Player()
    private var listOfPlayers = arrayListOf<Player>()



    /**
     * This method is called when the Activity is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Find the Button in the layout
        //val rollButton: Button = findViewById(R.id.rollbutton)
        binding.rollbutton.setText(player.getName() + " slag nr " + count)
        resTxt = ""
        binding.rollbutton.setOnClickListener {
            rollButtonClicked()
        }

        binding.playerButton.setOnClickListener {
            playersButtonClicked()
        }

        binding.stopbutton.setOnClickListener {
            stopButtonClicked()
        }
        // Set a click listener on the button to roll the dice when the user taps the button
       // get reference to ImageView
        val clickTerning1 = binding.terning1 as ImageView
        clickTerning1.setOnClickListener {
            t1.lockUnlock(findViewById(binding.terning1.id))
         }

        val clickTerning2 = binding.terning2 as ImageView
        clickTerning2.setOnClickListener {
            t2.lockUnlock(findViewById(binding.terning2.id))
        }

        val clickTerning3 = binding.terning3 as ImageView
        clickTerning3.setOnClickListener {
            t3.lockUnlock(findViewById(binding.terning3.id))
        }
        val clickTerning4 = binding.terning4 as ImageView
        clickTerning4.setOnClickListener {
            t4.lockUnlock(findViewById(binding.terning4.id))
        }
        val clickTerning5 = binding.terning5 as ImageView
        clickTerning5.setOnClickListener {
            t5.lockUnlock(findViewById(binding.terning5.id))
        }
        // Do a dice roll when the app starts
        rollDices()
    }

    private fun stopButtonClicked() {
        binding.result.text = "Du vil afbryde dine slag - er du sikker??\n"

    }

    private fun playersButtonClicked() {
        val intent = Intent(this, Players::class.java)
        intent.putExtra("listOfPlayers", listOfPlayers);
        startActivityForResult(intent, 0)
    }


    private fun rollButtonClicked() {
        rollDices()
        binding.result.text = ""
        count++
        binding.rollbutton.setText(player.getName() +" slag nr " + count)
        if (count > 3){
            Toast.makeText(this, "Du har ikke flere slag", Toast.LENGTH_SHORT).show()
            count = 1
            yatzy.calculateResult(t1, t2, t3, t4, t5)
            binding.rollbutton.setText(player.getName() + " slag nr " + count)
            binding.message.removeAllViews()
            val tv = TextView(this)
            tv.text = yatzy.getResultAsText()
            binding.message.addView(tv)

            t1.unlock()
            t2.unlock()
            t3.unlock()
            t4.unlock()
            t5.unlock()
            yatzy.reset()
        }
        else{
            binding.message.removeAllViews()
            val tv = TextView(this)
            tv.text = ""
            binding.message.addView(tv)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // If you have multiple activities returning results then you should include unique request codes for each
       if (requestCode == 0) {

            // The result code from the activity started using startActivityForResults
            if (resultCode == Activity.RESULT_OK) {
                var dat = data?.extras
                listOfPlayers = dat?.get("listOfPlayers") as ArrayList<Player>
                if (listOfPlayers.isNotEmpty()) {
                    player = listOfPlayers[0]
                    binding.rollbutton.setText(player.getName() + " slag nr " + count)
                }
           }
       }
    }

    private fun rollDices() {
        val diceImage1: ImageView = findViewById(R.id.terning1)
        t1.roll(diceImage1)
        val diceImage2: ImageView = findViewById(R.id.terning2)
        t2.roll(diceImage2)
        val diceImage3: ImageView = findViewById(R.id.terning3)
        t3.roll(diceImage3)
        val diceImage4: ImageView = findViewById(R.id.terning4)
        t4.roll(diceImage4)
        val diceImage5: ImageView = findViewById(R.id.terning5)
        t5.roll(diceImage5)
        }
    }


