package introduction

fun main(){

    val regex: Regex = getPattern().toRegex()
    val data: String = "05 JAN 1954"
    println(regex.containsMatchIn(data))
}

val month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"

fun getPattern(): String = """\d{2} $month \d{4}"""
