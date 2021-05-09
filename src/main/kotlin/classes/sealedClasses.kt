package classes

fun main(){

    val left = SeleadNum(30)
    val right = SeleadNum(25)

    println("${seleadEval(left)} ${seleadEval(right)}")
    println(seleadEval(SeleadSum(left, right)))

}

fun seleadEval (expr: SealedExpr): Int =
    when(expr){
        is SeleadNum -> expr.value
        is SeleadSum -> seleadEval(expr.left) + seleadEval(expr.right)
    }

sealed class SealedExpr

class SeleadNum(val value: Int) : SealedExpr()

class SeleadSum(val left: SealedExpr, val right: SealedExpr): SealedExpr()
