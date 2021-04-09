package com.sbaltinsoy.codelabs

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.done_button).setOnClickListener {
            addNickname(it)
        }

        findViewById<TextView>(R.id.nickname_text).setOnClickListener {
            updateNickname(it)
        }
    }

    @RequiresApi(Build.VERSION_CODES.CUPCAKE)
    private fun addNickname(view: View) {
       val editText = findViewById<EditText>(R.id.nickname_edit)
       val nicknameTextView = findViewById<TextView>(R.id.nickname_text)
       val altCizgiSil = editText.text.toString() +  " "
       nicknameTextView.text = altCizgiSil
       editText.visibility = View.GONE
        // button gizleniyor
       view.visibility = View.GONE
       nicknameTextView.visibility = View.VISIBLE
        // cikan klavyeyi gizle
        val imn = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imn.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname(view: View) {
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val doneButton = findViewById<Button>(R.id.done_button)

        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE

        // Set the focus to the edit text.
        editText.requestFocus()

        // Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)
    }
}