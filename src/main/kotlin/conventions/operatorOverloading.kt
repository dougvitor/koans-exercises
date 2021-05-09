package conventions

import conventions.MyDate
import java.util.*

fun main(){
    val today: MyDate = MyDate(2021, 5, 5)
    println(addTimeInterval(today))
    println(addRepeatedTimeInterval(today))
}

enum class TimeInterval{ DAY, WEEK, YEAR}

class RepeatedTimeInterval(val interval: TimeInterval, val number: Int)

operator fun TimeInterval.times(number: Int) = RepeatedTimeInterval(this, number)

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate = addTimeIntervals(timeInterval, 1)

operator fun MyDate.plus(repeatedTimeInterval: RepeatedTimeInterval) = addTimeIntervals(
    repeatedTimeInterval.interval,
    repeatedTimeInterval.number
)

fun MyDate.addTimeIntervals(timeInterval: TimeInterval, amount: Int): MyDate {
    val c = Calendar.getInstance()
    c.set(year + if(timeInterval == TimeInterval.YEAR) amount else 0, month, dayOfMonth)
    var timeInMillis = c.timeInMillis
    val millisecondsInADay = 24 * 60 * 60 * 1000L

    timeInMillis += amount * when(timeInterval){
        TimeInterval.DAY -> millisecondsInADay
        TimeInterval.WEEK -> 7 * millisecondsInADay
        TimeInterval.YEAR -> 0
    }

    val result = Calendar.getInstance()
    result.timeInMillis = timeInMillis

    return MyDate(
        result.get(Calendar.YEAR),
        result.get(Calendar.MONTH),
        result.get(Calendar.DATE)
    )
}

fun addTimeInterval(today: MyDate): MyDate {
    return today + TimeInterval.YEAR + TimeInterval.WEEK
}

fun addRepeatedTimeInterval(today: MyDate): MyDate  {
    return today + (TimeInterval.YEAR * 2) + (TimeInterval.WEEK * 3) + (TimeInterval.DAY * 5)
}