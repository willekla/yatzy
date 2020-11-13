package com.example.diceroller

import android.R.drawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
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
    var resTxt = ""
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
        // set on-click listener
        clickTerning1.setOnClickListener {
            val diceImage: ImageView = findViewById(binding.terning1.id)
            val drawableResource =  R.drawable.dice_1_last
            diceImage.setImageResource(drawableResource)

            // your code to perform when the user clicks on the ImageView
            Toast.makeText(this@MainActivity, "You clicked on ImageViewterning1.", Toast.LENGTH_SHORT).show()
        }
        // Do a dice roll when the app starts
        rollDices()
    }

    private fun rollDices() {
        resTxt = "";
        val diceImage1: ImageView = binding.terning1
        resTxt = resTxt  + rollDice(diceImage1).toString()

        val diceImage2: ImageView = binding.terning2
        resTxt = resTxt  + ", " + rollDice(diceImage2)

        val diceImage3: ImageView = binding.terning3
        resTxt = resTxt  + ", " + rollDice(diceImage3)

        val diceImage4: ImageView = binding.terning4
        resTxt = resTxt  + ", " + rollDice(diceImage4)

        val diceImage5: ImageView = binding.terning5
        resTxt = resTxt  + ", " + rollDice(diceImage5)
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice(diceImage: ImageView): Int {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(diceImage.id)

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
        return diceRoll
    }

}

/**
 * Dice with a fixed number of sides.
 */
class Dice(private val numSides: Int) {

    /**
     * Do a random dice roll and return the result.
     */
    fun roll(): Int {
        return (1..numSides).random()
    }


}