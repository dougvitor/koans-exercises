package classes

import kotlin.random.Random as KRandom
import java.util.Random as JRandom

fun main(){
    println(useDifferentRandomClasses())
}

fun useDifferentRandomClasses(): String =
    """
        Kotlin random: ${KRandom.nextInt(100)}
        Java random: ${JRandom().nextInt(100)} 
    """.trimIndent()