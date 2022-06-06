package com.example.helloclick

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class MainActivity : AppCompatActivity() {
    var i = 0
    var inc = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        updateIncrement()

        // finding the button using the viewId
        val clickMe : Button = findViewById(R.id.main_click)
        val resetButton : Button = findViewById(R.id.main_reset)
        val reverseButton : Button = findViewById(R.id.main_reverse)
        val normalButton : Button = findViewById(R.id.main_normal);
        val bigButton : Button = findViewById(R.id.main_big);

        // click listeners for buttons
        clickMe.setOnClickListener(this::button)
        resetButton.setOnClickListener(this::reset)
        reverseButton.setOnClickListener(this::reverse)
        normalButton.setOnClickListener(this::normal)
        bigButton.setOnClickListener(this::big)

//        val toast = Toast.makeText(this@MainActivity, "text", Toast.LENGTH_SHORT)
//        toast.show()
    }

    private fun updateIncrement() {
        val text = findViewById<TextView>(R.id.main_counter)
        text.text = i.toString()
    }

    private fun button(view : View) {
        i += inc;
        updateIncrement();
    }

    private fun reset(view: View) {
        i = 0;
        inc = 1;
        updateIncrement();
    }

    private fun reverse(view: View) {
        inc *= -1;
    }

    private fun normal(view: View) {
        inc = 1 * if (inc < 0) -1 else 1
    }

    private fun big(view: View) {
        inc = 5 * if (inc < 0) -1 else 1
    }
}