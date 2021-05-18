package builders

fun main(){

    println(usage().values)

}

fun buildMutableMap(build: HashMap<Int, String>.() -> Unit): HashMap<Int, String> {
    val hashMap = HashMap<Int, String>()
    hashMap.build()
    return hashMap
}

fun usage(): Map<Int, String>{
    return buildMutableMap {
        put(0, "0")

        for(i in 1..10){
            put(i, "$i")
        }
    }
}