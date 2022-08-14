package com.example.ktcalendar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentData = Calendar.getInstance() // Data container
        var year = currentData.get(Calendar.YEAR) // Year
        var month = currentData.get(Calendar.MONTH) + 1 // Month in Int
        var day = currentData.get(Calendar.DAY_OF_MONTH)

        monthNameTitle.text = "${getMonthText(month)} $year" // Start title text

        val gridListItems = MutableList<String>(getNumDaysInMonth(month), { x -> "${x + 1}" })
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, gridListItems)
        gridView.adapter = adapter
        gridView.numColumns = 7

        buttonNext.setOnClickListener {

            if (month != 12) {
                month++
            } else {
                month = 1
                year ++
            }

            gridListItems.clear() // это наверника делается не так, но пока так)
            for (i in 1..getNumDaysInMonth(month)) {
                gridListItems.add(i.toString())
            }
            adapter.notifyDataSetChanged()

            monthNameTitle.text = "${getMonthText(month)} $year"
        }

        buttonBack.setOnClickListener {
            if (month != 1) {
                month--
            } else {
                month = 12
                year --
            }

            gridListItems.clear()
            for (i in 1..getNumDaysInMonth(month)) {
                gridListItems.add(i.toString())
            }
            adapter.notifyDataSetChanged()

            monthNameTitle.text = "${getMonthText(month)} $year"
        }
    }

    fun getNumDaysInMonth(month: Int): Int {
        return when (month) {
            1, 3, 5, 7, 8, 10, 12 -> 31
            4, 6, 9, 11 -> 30
            2 -> 28
            else -> throw Exception("Month must be in 1..12")
        }
    }

    fun getMonthText(month: Int): String {
        return when (month) {
            1 -> "January"
            2 -> "February"
            3 -> "March"
            4 -> "April"
            5 -> "May"
            6 -> "June"
            7 -> "Jule"
            8 -> "August"
            9 -> "September"
            10 -> "October"
            11 -> "November"
            12 -> "December"
            else -> throw Exception("Month must be in 1..12")
        }
    }
}