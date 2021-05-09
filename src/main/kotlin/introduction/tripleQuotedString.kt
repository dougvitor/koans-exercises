package introduction

fun main(){
    println(tripleQuotedString)
}
const val question = "life, the universe, and everything"

const val answer = 42

val tripleQuotedString = """
    #question = "$question"
    #answer = $answer""".trimMargin(marginPrefix = "#")
