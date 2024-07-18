package com.example.test


import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.AdapterView
import android.view.View


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.signup2)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.extra_info)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Spinner 초기화
        setupSpinners()


    }

    private fun setupSpinners() {
        val yearSpinner: Spinner = findViewById(R.id.yearSpinner)
        val monthSpinner: Spinner = findViewById(R.id.monthSpinner)
        val daySpinner: Spinner = findViewById(R.id.daySpinner)

        // 년도 Spinner
        val years = (1923..2023).toList()
        val yearAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, years)
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        yearSpinner.adapter = yearAdapter

        // 월 Spinner
        val months = (1..12).toList()
        val monthAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, months)
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        monthSpinner.adapter = monthAdapter

        // 날짜 Spinner 초기화
        updateDays(daySpinner, yearSpinner.selectedItem as Int, monthSpinner.selectedItem as Int)

        // 년도 선택 이벤트 처리
        yearSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                updateDays(daySpinner, yearSpinner.selectedItem as Int, monthSpinner.selectedItem as Int)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        // 월 선택 이벤트 처리
        monthSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                updateDays(daySpinner, yearSpinner.selectedItem as Int, monthSpinner.selectedItem as Int)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    // 월별 날짜 수, 윤년 고려해서 2월 날짜 수
    private fun updateDays(daySpinner: Spinner, year: Int, month: Int) {
        val daysInMonth = when (month) {
            1, 3, 5, 7, 8, 10, 12 -> 31
            4, 6, 9, 11 -> 30
            2 -> if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) 29 else 28
            else -> 31
        }
        val days = (1..daysInMonth).toList()
        val dayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, days)
        dayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        daySpinner.adapter = dayAdapter
    }
}
