package classes

fun main(){

    val alice: Person = Person(name = "Alice", age = 18)
    val bob: Person = Person(name = "Bob", age = 30)
    val aliceCopy: Person = Person(name = "Alice", age = 18)
    println(alice.name)
    println(alice.hashCode())
    println(alice.toString())
    println(alice == bob)
    println(alice == aliceCopy)

}

data class Person(val name: String, val age: Int)
