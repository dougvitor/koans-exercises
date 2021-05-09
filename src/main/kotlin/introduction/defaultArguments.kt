package introduction

fun main(){
    println(useFoo())
}

fun foo(name: String = "", number: Int = 42, toUpperCase: Boolean = false) =
    (if (toUpperCase) name.toUpperCase() else name) + number

fun useFoo () = listOf(
    foo("a"),
    foo("b", 1),
    foo("c", toUpperCase = true),
    foo("d", 2, true)
)
