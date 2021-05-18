package builders

fun main(){
    val isEven: Int.() -> Boolean = { this % 2 == 0  }
    val isOdd: Int.() -> Boolean = {!isEven()}

    println(listOf(42.isOdd(), 239.isOdd(), 294823098.isEven()))
}