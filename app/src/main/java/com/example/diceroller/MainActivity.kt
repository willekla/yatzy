package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {

    /**
     * This method is called when the Activity is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the Button in the layout
        val rollButton: Button = findViewById(R.id.button)

        // Set a click listener on the button to roll the dice when the user taps the button
        rollButton.setOnClickListener { rollDices() }

        // Do a dice roll when the app starts
        rollDices()
    }

    private fun rollDices() {
        val diceImage1: ImageView = findViewById(R.id.terning1)
        val dice1 = rollDice(diceImage1)

        val diceImage2: ImageView = findViewById(R.id.terning2)
        val dice2 = rollDice(diceImage2)

        val diceImage3: ImageView = findViewById(R.id.terning3)
        val dice3 = rollDice(diceImage3)

        val diceImage4: ImageView = findViewById(R.id.terning4)
        val dice4 = rollDice(diceImage4)

        val diceImage5: ImageView = findViewById(R.id.terning5)
        val dice5 = rollDice(diceImage5)
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