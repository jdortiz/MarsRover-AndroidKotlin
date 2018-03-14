package com.canonicalexamples.marsrover

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.canonicalexamples.marsrover.model.Rover

import kotlinx.android.synthetic.main.activity_mars_rover.*
import kotlinx.android.synthetic.main.content_mars_rover.*

class MarsRoverActivity : AppCompatActivity() {

    private val rover = Rover(x = 0, y = 0, direction = 'N')

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mars_rover)
        setSupportActionBar(toolbar)

        moveRoverButton.setOnClickListener { _ ->
            val commands = commandsEditText.text.toString()
            rover.execute(commands = commands)
            positionTextView.text = rover.toString()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_mars_rover, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
