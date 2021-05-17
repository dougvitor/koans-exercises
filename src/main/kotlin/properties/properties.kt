package properties

fun main(){

    val propertyExample = PropertyExample()
    propertyExample.propertyWithCounter = 1
    propertyExample.propertyWithCounter = 2
    propertyExample.propertyWithCounter = 8

    println(propertyExample.propertyWithCounter)
    println(propertyExample.counter)

}

class PropertyExample(){
    var counter = 0
        private set

    var propertyWithCounter: Int? = null
        set (value){
            field = value
            counter++
        }
}
