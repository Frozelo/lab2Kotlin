package com.example.lab2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.abs

class MainActivity: AppCompatActivity() {

    private lateinit var epsilonInput: EditText
    private lateinit var resultView: TextView
    private lateinit var calculateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        epsilonInput = findViewById(R.id.editTextNumberDecimal)
        resultView = findViewById(R.id.resultText)
        calculateButton = findViewById(R.id.calculateButton)

        calculateButton.setOnClickListener {
            val epsilon = epsilonInput.text.toString().toDoubleOrNull()

            if (epsilon != null && epsilon > 0) {
                val result = calculateSeriesSum(epsilon)
                resultView.text = result
            } else {
                resultView.text = "Пожалуйста, введите допустимое значение для порога."
            }
        }
    }
    private fun factorial(n: Int): Double {
        if (n == 0) {
            return 1.0
        } else {
            return n * factorial(n - 1)
        }
    }
    private fun calculateSeriesSum(epsilon: Double): String {
        println("im here!")
        println(epsilon)
        var sum = 0.0
        var term: Double
        var n = 1
        var iterations = 0

        do {
            term = 1.0 / factorial(n)
            sum += term
            n += 2
            iterations ++
        } while(term > epsilon)
        return "Сумма: $sum\nПоследнее слагаемое: $term\nЧисло итераций: $iterations"
    }

}

