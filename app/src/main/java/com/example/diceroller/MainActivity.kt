package com.example.diceroller


import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.diceroller.com.example.diceroller.Player
import com.example.diceroller.com.example.diceroller.Yatzy
import com.example.diceroller.databinding.ActivityMainBinding


/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var radioGroup: RadioGroup
    private var count = 1
    private var resTxt = ""

    private val t1 = Dice()
    private val t2 = Dice()
    private val t3 = Dice()
    private val t4 = Dice()
    private val t5 = Dice()
    private val yatzy = Yatzy()
    private var player = Player()
    private var listOfPlayers = arrayListOf<Player>()
    private var currentPlayer = 0


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
        setTextOnRollbutton(player, count)
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
        val clickTerning1 = binding.terning1
        clickTerning1.setOnClickListener {
            t1.lockUnlock(findViewById(binding.terning1.id), count)
        }

        val clickTerning2 = binding.terning2
        clickTerning2.setOnClickListener {
            t2.lockUnlock(findViewById(binding.terning2.id), count)
        }

        val clickTerning3 = binding.terning3
        clickTerning3.setOnClickListener {
            t3.lockUnlock(findViewById(binding.terning3.id), count)
        }
        val clickTerning4 = binding.terning4
        clickTerning4.setOnClickListener {
            t4.lockUnlock(findViewById(binding.terning4.id), count)
        }
        val clickTerning5 = binding.terning5
        clickTerning5.setOnClickListener {
            t5.lockUnlock(findViewById(binding.terning5.id), count)
        }
        // Do a dice roll when the app starts
        rollDices()
    }

    private fun stopButtonClicked() {
        binding.result.text = "Du vil afbryde dine slag - er du sikker??\n"
    }


    private fun rollButtonClicked() {
        rollDices()
        binding.result.text = ""
        count++
        setTextOnRollbutton(player, count)
        if (count > 3) {
            Toast.makeText(this, "Du har ikke flere slag", Toast.LENGTH_SHORT).show()
            count = 1
            yatzy.calculateResult(t1, t2, t3, t4, t5)
            if (listOfPlayers.isNotEmpty()) {
                binding.message.removeAllViews()
                val tv = TextView(this)
                tv.text = yatzy.getResultAsText(this.applicationContext)

                radioGroup = RadioGroup(this)
                val options = yatzy.getResultAsArray()
                for (i in options.indices) {
                    // create a radio button
                    val rb = RadioButton(this)
                    // set text for the radio button
                    rb.text = options[i]
                    // assign an automatically generated id to the radio button
                    rb.id = View.generateViewId()
                    // add radio button to the radio group
                    radioGroup.addView(rb)
                }

                radioGroup.setOnCheckedChangeListener { group, checkedId ->
                    val radio: RadioButton = findViewById(checkedId)
                    Toast.makeText(applicationContext, " On checked change :" +
                            " ${radio.text}  ",
                            Toast.LENGTH_LONG).show()


                    player.setScore(yatzy.getScore(this.applicationContext, radio.text))
                    createConfirmButton(radio.text)

                    currentPlayer++
                    if (currentPlayer >= listOfPlayers.size) {
                        currentPlayer = 0
                    }
                    player = listOfPlayers[currentPlayer]
                }
                binding.message.addView(radioGroup)

            } else {
                binding.message.removeAllViews()
                val tv = TextView(this)
                tv.text = ""
                binding.message.addView(tv)
            }
            t1.unlock()
            t2.unlock()
            t3.unlock()
            t4.unlock()
            t5.unlock()
            yatzy.reset()
        }
    }

    private fun setTextOnRollbutton(player: Player, count: Int) {
        val txt = player.getName() + this.applicationContext.getString(R.string.throw_number) + count
        if (count < 4 ) {
            binding.rollbutton.setText(txt)
        } else {
            binding.rollbutton.setText(getString(R.string.no_more_moves))
        }
    }

    // ---- create players
    private fun playersButtonClicked() {
        val intent = Intent(this, Players::class.java)
        intent.putExtra("listOfPlayers", listOfPlayers)
        startActivityForResult(intent, 0)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // If you have multiple activities returning results then you should include unique request codes for each
        if (requestCode == 0) {

            // The result code from the activity started using startActivityForResults
            @Suppress("UNCHECKED_CAST")
            if (resultCode == Activity.RESULT_OK) {
                val dat = data?.extras
                listOfPlayers = dat?.get("listOfPlayers") as ArrayList<Player>
                if (listOfPlayers.isNotEmpty()) {
                    player = listOfPlayers[0]
                    currentPlayer = 0
                    setTextOnRollbutton(player, count)
                }
            }
        }
    }
    // ---- create players end

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

    private fun createConfirmButton(text: CharSequence) {
        // creating the button
        val dynamicButton = Button(this)
        // setting layout_width and layout_height using layout parameters
        dynamicButton.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        )

        dynamicButton.text = getString(R.string.ok_choise)
        dynamicButton.setBackgroundColor(Color.GREEN)

        dynamicButton.setOnClickListener {
            binding.root.removeView(dynamicButton)
            binding.message.removeAllViews()
            binding.linearLayout.removeAllViews()
            if (!listOfPlayers.isEmpty()) {
                listOfPlayers[currentPlayer].setChoice(text)
                setTextOnRollbutton(player, count)
            }
        }
        // add Button to LinearLayout
        binding.linearLayout.addView(dynamicButton)
    }
}


