package introduction

import conventions.MyDate
import java.util.*
import kotlin.NoSuchElementException

fun main(){

    val first: MyDate = MyDate(2020, 1, 6)
    val last: MyDate = MyDate(2021, 5, 6)

    iterateOverDateRange(first, last){
        println(it)
    }

}

class DateRange(val start: MyDate, val end: MyDate): Iterable<MyDate>{
    override fun iterator(): Iterator<MyDate>{
        return object: Iterator<MyDate>{
            var current: MyDate = start

            override fun hasNext(): Boolean = current <= end

            override fun next(): MyDate {
                if(!hasNext()) throw NoSuchElementException()

                val result = current
                current = current.followingDate()
                return result
            }
        }
    }
}

fun MyDate.followingDate(): MyDate{
    val c = Calendar.getInstance()
    c.set(year, month, dayOfMonth)

    val millisecondsInADay = 24 * 60 * 60 * 1000L
    val timeInMillis = c.timeInMillis + millisecondsInADay

    val result = Calendar.getInstance()
    result.timeInMillis = timeInMillis

    return MyDate(
        result.get(Calendar.YEAR),
        result.get(Calendar.MONTH),
        result.get(Calendar.DATE)
    )

}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit){
    for (date in firstDate..secondDate){
        handler(date)
    }
}


