package com.example.diceroller

import android.widget.ImageView

class Dice() {
    private var dots = 1
    private var locked = false

    fun lock() {
        locked = true
    }

    // member function
    fun unlock() {
        locked = false
    }

    fun islocked(): Boolean {
        return locked
    }


    fun getDots (): Int {
        return dots
    }

    fun roll(diceImage: ImageView) {
        if (!locked) {
            dots = (1..6).random()
            var drawableResource = this.getImage()
            diceImage.setImageResource(drawableResource  )
            diceImage.contentDescription = dots.toString()
        }
    }

    fun getImage(): Int {
        var drawableResource = 0
        if (!islocked()){
            drawableResource = when (dots) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                else -> R.drawable.dice_5
            }
        } else{
            drawableResource = when (dots) {
                1 -> R.drawable.dice_1_last
                2 -> R.drawable.dice_2_last
                3 -> R.drawable.dice_3_last
                4 -> R.drawable.dice_4_last
                else -> R.drawable.dice_5_last
            }
        }
        return drawableResource
    }

    fun lockUnlock(findViewById: ImageView) {
       if (locked){
            unlockDice()
        } else{
            lockDice()
        }
        val diceImage: ImageView = findViewById
        diceImage.setImageResource(getImage()  )
    }

    private fun lockDice() {
        locked = true
    }

    private fun unlockDice() {
        locked = false
    }
}