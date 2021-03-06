package com.example.diceroller


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.diceroller.com.example.diceroller.Player


class Players : AppCompatActivity() {
    private var listOfPlayers = arrayListOf<Player>()
    private val player1 = Player()
    private val player2= Player()
    private val player3 = Player()
    private val player4= Player()
    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var editText3: EditText
    private lateinit var editText4: EditText
    private lateinit var personName1: String
    private lateinit var personName2: String
    private lateinit var personName3: String
    private lateinit var personName4: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_players)
        fillListOfPlayersFromMain(intent)

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = getString(R.string.back_to_game)        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    private fun fillListOfPlayersFromMain(intent: Intent?) {
        listOfPlayers = getIntent().getSerializableExtra("listOfPlayers") as ArrayList<Player>;
        editText1 = findViewById(R.id.PersonName1)
        editText2 = findViewById(R.id.PersonName2)
        editText3 = findViewById(R.id.PersonName3)
        editText4 = findViewById(R.id.PersonName4)
        if (listOfPlayers.size> 0) {
            editText1.setText(listOfPlayers[0].getName())
        }
        if (listOfPlayers.size> 1) {
            editText2.setText(listOfPlayers[1].getName())
        }
        if (listOfPlayers.size> 2){
            editText3.setText(listOfPlayers[2].getName())
        }
        if (listOfPlayers.size> 3) {
            editText4.setText(listOfPlayers[3].getName())
        }
    }

    override fun onSupportNavigateUp(): Boolean {

        editText1 = findViewById(R.id.PersonName1)
        editText2 = findViewById(R.id.PersonName2)
        editText3 = findViewById(R.id.PersonName3)
        editText4 = findViewById(R.id.PersonName4)
        personName1 = editText1.text.toString()
        personName2 = editText2.text.toString()
        personName3 = editText3.text.toString()
        personName4 = editText4.text.toString()
        listOfPlayers = arrayListOf<Player>()
        if (!personName1.isBlank()) {
            player1.setName(personName1)
            listOfPlayers.add(player1)
        }
        if (!personName2.isBlank()) {
            player2.setName((personName2))
            listOfPlayers.add(player2)
        }
        if (!personName3.isBlank()) {
            player3.setName((personName3))
            listOfPlayers.add(player3)
        }
        if (!personName4.isBlank()) {
            player4.setName((personName4))
            listOfPlayers.add(player4)
        }

        val intent = Intent()
        intent.putExtra("listOfPlayers", listOfPlayers)
        setResult(RESULT_OK, intent)
        finish()
        onBackPressed()
        return true
    }
}

