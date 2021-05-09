package introduction

import conventions.MyDate

fun main() {

    val date: MyDate = MyDate(2021, 5, 6)
    val first: MyDate = MyDate(2020, 1, 6)
    val last: MyDate = MyDate(2021, 5, 6)

    println(checkInRange(date, first, last))
}

fun checkInRange(date: MyDate, first: MyDate, last: MyDate): Boolean =  date in first..last
