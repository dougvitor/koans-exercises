package introduction

fun main(){
    val lista = listOf("Ana", "Gilmar", "Matheus", "Deco")
    println(joinOptions(lista))
}

fun joinOptions(options: Collection<String>) = options.joinToString ( prefix = "(", postfix = ")" )