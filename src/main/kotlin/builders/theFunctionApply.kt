package builders

import java.lang.StringBuilder

fun main(){

    println(createString())
    println(createMap())

}

fun <T> T.myApply(f: T.() -> Unit): T{
    this.f()
    return this
}

fun createString(): String{

    return StringBuilder().myApply {
        append("Number: ")
        for(i in 1..10){
            append(i)
        }
    }.toString()

}

fun createMap(): Map<Int, String>{
    return HashMap<Int, String>().myApply {
        put(0, "0")
        for(i in 1..10){
            put(i, "$i")
        }
    }
}