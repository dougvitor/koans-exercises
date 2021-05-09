package introduction

fun main(){
    check(1000)
}

fun failWithWrongAge(age: Int?): Nothing{
    throw IllegalArgumentException("Wrong age: $age")
}

fun check(age: Int?){
    if(age == null || age !in 0..150) failWithWrongAge(age)

    println("Congrats! Next year you'll be ${age + 1}")
}
