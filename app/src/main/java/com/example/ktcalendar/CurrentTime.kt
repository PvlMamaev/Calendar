package com.example.ktcalendar

import android.util.Log
import java.lang.Exception
import java.util.*

class CurrentTime {
    val c = Calendar.getInstance()
    fun getMonth(): String {
        return when (c.get(Calendar.MONTH) + 1) { // у меня почему то на 1 меньше
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

    fun getYear(): Int {
        return c.get(Calendar.YEAR)
    }

    fun getDay(): Int {
        return c.get(Calendar.DAY_OF_MONTH)
    }

    fun getDayWeek(): Int {
        return c.get(Calendar.DAY_OF_WEEK)
    }
}