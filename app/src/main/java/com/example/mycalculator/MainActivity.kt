package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_plus.setOnClickListener() {
           check(first_number_input.text.toString(), second_number_input.text.toString(), '+')
        }

        btn_minus.setOnClickListener() {
            check(first_number_input.text.toString(), second_number_input.text.toString(), '-')
        }

        btn_multiple.setOnClickListener() {
            check(first_number_input.text.toString(), second_number_input.text.toString(), '*')
        }

        btn_div.setOnClickListener() {
            check(first_number_input.text.toString(), second_number_input.text.toString(), '/')
        }
    }

    private fun check(firstRow: String, secondRow: String, operator: Char) {
        if (firstRow.isEmpty()) {
            first_number_input.error = "Please Add a Number"
        } else if (secondRow.isEmpty()) {
            second_number_input.error = "Please Add a Number"
        } else if (firstRow.isNotEmpty() && secondRow.isNotEmpty()) {
            calculation(firstRow.toDouble(), secondRow.toDouble(), operator)
        }
    }

    private fun calculation(firstRow: Double, secondRow: Double, operator: Char) {
        var result = 0.0
        when (operator) {
            '+' -> result = firstRow + secondRow
            '-' -> result = firstRow - secondRow
            '*' -> result = firstRow * secondRow
            '/' -> result = firstRow / secondRow
        }
        tv_result.text = result.toString()
    }
}