package classes

import java.lang.IllegalArgumentException

fun main(){

    val entrada1 = Num(12)
    val entrada2 = Num(value = 35)

    println("${eval(entrada1)}  ${eval(entrada2)}")
    println(eval(Sum(entrada1, entrada2)))
    println(eval(object: Expr{}))

}

interface Expr

class Num(val value: Int): Expr

class Sum(val left: Expr, val right: Expr) : Expr

fun eval(expr: Expr): Int = when{
    expr is Num -> expr.value
    expr is Sum -> eval(expr.left) + eval(expr.right)
    else -> throw IllegalArgumentException("Unknow expression")
}