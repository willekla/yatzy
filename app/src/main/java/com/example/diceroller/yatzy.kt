package com.example.diceroller

import android.widget.Button
import android.widget.ImageView
import com.example.diceroller.databinding.ActivityMainBinding


object Yatzy {
/*
    fun kastTerningerne(rollButton: Button) {
        rollButton.setOnClickListener {
            rollDice(R.id.terning1)
            rollDice(R.id.terning2)
            rollDice(R.id.terning3)
            rollDice(R.id.terning4)
            rollDice(R.id.terning5)

        }

    }*/
/*

    fun rollDice(terning2: Int) {
        val dice = MainActivity.Dice(6)
        val diceRoll = (1..6).random()/*
        val diceImage: ImageView = MainActivity.findViewById(terning)

        when (diceRoll) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }*/

    }*/
/*
    fun roll(binding: ActivityMainBinding) {
        val dice = MainActivity.Dice(6)
        val diceRoll = (1..6).random()
        val d = binding.
        val diceImage: ImageView = MainActivity.findViewById(terning)

        when (diceRoll) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }


    }*/
}

private fun roll(i: Int): Any {
    return (1..i).random()
}
/*
package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.diceroller.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener { Yatzy.roll(binding) }

        val rollButton: Button = findViewById(R.id.button)
        Yatzy.kastTerningerne(rollButton);
        rollButton.setOnClickListener {

            val array = arrayOfNulls<Number>(5)
            array[0] = rollDice(R.id.terning1)
            array[1] = rollDice(R.id.terning2)
            array[2] = rollDice(R.id.terning3)
            array[3] = rollDice(R.id.terning4)
            array[4] = rollDice(R.id.terning5)

            //Toast.makeText(this.getBaseContext(), "Du har ikke flere slag" as String?,
            //        Toast.LENGTH_SHORT).show()

        }
    }

    private fun rollDice(terning: Int): Int {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage: ImageView = findViewById(terning)

        when (diceRoll) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
        }
        return diceRoll
    }

    class Dice(private val numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}

*/


