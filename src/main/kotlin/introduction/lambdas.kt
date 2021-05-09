package introduction

fun main(){
    println(containsPar(mutableListOf(5, 3, 2)))
}

fun containsPar(collection: Collection<Int>): Boolean = collection.any { it % 2 == 0 }
