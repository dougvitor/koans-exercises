package classes

fun main(){
    val number = Pair(5, 3).r()
    println(number)
}

data class RationalNumber(val numerator: Int, val denominator: Int)

fun Pair<Int, Int>.r(): RationalNumber = RationalNumber(first, second)