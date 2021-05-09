package conventions

import introduction.DateRange

fun main() {

    val dataInicial: MyDate = MyDate(2020, 1, 6)
    val dataFinal: MyDate = MyDate(2021, 4, 30)

    println(dataFinal < dataInicial)
}

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {

    override fun compareTo(other: MyDate): Int = when {
        year != other.year -> year - other.year
        month != other.month -> month - other.month
        else -> dayOfMonth - other.dayOfMonth
    }

    operator fun rangeTo(other: MyDate) = DateRange(this, other)
}
