package com.example.customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.core.text.isDigitsOnly
import androidx.core.widget.doOnTextChanged

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.textView)
        val editText = findViewById<EditText>(R.id.editText)
        var verticlaSlider = findViewById<VerticalSlider>(R.id.verticalSlider)

        editText.doOnTextChanged { text, start, before, count ->
            if (text?.isNotEmpty() == true) {
                if (text?.isDigitsOnly() == true) {
                    val number = text.toString().toInt()
                    if (number >= 0 && number <= 100) {
                        verticlaSlider.value = number
                    }
                }
            }
        }

        verticlaSlider.setOnValueChanged { value ->
            textView.text = "${value}%"

            if (value == 100)
                textView.setBackgroundResource(R.color.green)
            else
                textView.setBackgroundResource(R.color.red)


            editText.hint = "${value}%"
        }
    }
}
