package com.example.diceroller

import Dice
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.diceroller.databinding.ActivityMainBinding

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var count = 3;
    private var resTxt = ""
    private var antalOejne1 = 1
    private var antalOejne2 = 1
    private var antalOejne3 = 1
    private var antalOejne4 = 1
    private var antalOejne5 = 1
    private var locked1 = false
    private var locked2 = false
    private var locked3 = false
    private var locked4 = false
    private var locked5 = false

    /**
     * This method is called when the Activity is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Find the Button in the layout
        val rollButton: Button = findViewById(R.id.rollbutton)

        resTxt = ""
        binding.rollbutton.setOnClickListener { rollDices()
            binding.result.text = ""
            count--
            if (count == 0){
                Toast.makeText(this, "Du har ikke flere slag", Toast.LENGTH_SHORT).show()
                count = 3
                binding.result.text = "du har slået: " + resTxt
            }
        }


        // Set a click listener on the button to roll the dice when the user taps the button
       // get reference to ImageView
        val clickTerning1 = binding.terning1 as ImageView
        clickTerning1.setOnClickListener {
            val diceImage: ImageView = findViewById(binding.terning1.id)
            locked1 = Yatzy.clickListenerDice1(diceImage, locked1)
        }

        val clickTerning2 = binding.terning2 as ImageView
        clickTerning2.setOnClickListener {
            val diceImage: ImageView = findViewById(binding.terning2.id)
            locked2 = Yatzy.clickListenerDice1(diceImage, locked2)
        }

        val clickTerning3 = binding.terning3 as ImageView
        clickTerning3.setOnClickListener {
            val diceImage: ImageView = findViewById(binding.terning3.id)
            locked3 = Yatzy.clickListenerDice1(diceImage, locked3)
        }

        val clickTerning4 = binding.terning4 as ImageView
        clickTerning4.setOnClickListener {
            val diceImage: ImageView = findViewById(binding.terning4.id)
            locked4 = Yatzy.clickListenerDice1(diceImage, locked4)
        }

        val clickTerning5 = binding.terning5 as ImageView
        clickTerning5.setOnClickListener {
            val diceImage: ImageView = findViewById(binding.terning5.id)
            locked5 = Yatzy.clickListenerDice1(diceImage, locked5)
        }
        // Do a dice roll when the app starts
        rollDices()
    }

    private fun rollDices() {
        resTxt = "";
        if (!locked1) {
            val diceImage1: ImageView = binding.terning1
            antalOejne1 = rollDice(diceImage1)
        }
        if (!locked2) {
            val diceImage2: ImageView = binding.terning2
            antalOejne2 = rollDice(diceImage2)
        }
        if (!locked3) {
            val diceImage3: ImageView = binding.terning3
            antalOejne3 = rollDice(diceImage3)
        }
        if (!locked4) {
            val diceImage4: ImageView = binding.terning4
            antalOejne4 = rollDice(diceImage4)
        }
        if(!locked5){
            val diceImage5: ImageView = binding.terning5
            antalOejne5 = rollDice(diceImage5)
        }
    }


    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice(diceImage: ImageView): Int {
        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(diceImage.id)
        Yatzy.rollDice(diceImage)
        val dice = Dice(6)
        val diceRoll = dice.roll()
        return diceRoll

    }

}

