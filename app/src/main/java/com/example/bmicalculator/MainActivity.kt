package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    lateinit var heightEditText: EditText
    lateinit var weightTextView: TextView
    lateinit var minusButton: Button
    lateinit var addButton: Button
    lateinit var descriptionTextView: TextView
    lateinit var resultTextView: TextView
    lateinit var clickButton: Button
    lateinit var bodyComposition: TextView

    var height: Int = 150
    var weight: Int = 70
    var body: String = ""
    var resultAsString: String =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        heightEditText = findViewById(R.id.heightEditText)
        weightTextView = findViewById(R.id.weightTextView)
        minusButton = findViewById(R.id.minusButton)
        addButton = findViewById(R.id.addButton)
        descriptionTextView = findViewById(R.id.descriptionTextView)
        resultTextView = findViewById(R.id.resultTextView)
        bodyComposition = findViewById(R.id.bodyCompositionTextView)
        clickButton = findViewById(R.id.clickButton)

        setHeight()
        setWeight()


        minusButton.setOnClickListener {
            weight--
            setWeight()
        }

        addButton.setOnClickListener {
            weight++
            setWeight()
        }

        clickButton.setOnClickListener {
            height = heightEditText.text.toString().toInt()

            val result = weight / (height / 100f).pow(2)
            val resultAsString = String.format("%.2f", result)

            resultTextView.text = resultAsString
            setBodyComposition(result)
        }


    }

    fun setHeight() {
        heightEditText.setText(height.toString())
    }

    fun setWeight() {
        weightTextView.text = "$weight"

    }

    fun setBodyComposition(resultTextView: Float) {

        if (resultTextView <= 18.5) {
            body = "Peso inferior al normal"
        } else if (resultTextView > 18.5 && resultTextView <= 24.9) {
            body = "Normal"
        } else if (resultTextView > 25.0 && resultTextView <= 29.9) {
            body = "Peso superior al normal"
        } else if (resultTextView > 30.0 && resultTextView> 300) {
            body = "Obesidad"
        }
        bodyComposition.text= "$body"

    }
}