import android.widget.ImageView
import com.example.diceroller.R

object Yatzy {
    fun rollDice(diceImage: ImageView): Int {
        val dice = Dice(6)
        val diceRoll = dice.roll()
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

    fun clickListenerDice1(diceImage: ImageView, locked: Boolean): Boolean {
        var newLocked = false;
        var drawableResource = R.drawable.dice_1
        if (locked){
        } else{
            drawableResource =  R.drawable.dice_1_last
            newLocked = true
        }
        diceImage.setImageResource(drawableResource  )
        return newLocked
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