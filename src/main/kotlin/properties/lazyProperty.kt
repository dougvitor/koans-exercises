package properties

fun main(){

    val lazyProperty = LazyProperty {
        25
    }

    println(lazyProperty.lazy)
    lazyProperty.value = 10
    println(lazyProperty.lazy)

}

class LazyProperty(val initializer: () -> Int){
    var value: Int? = null
    val lazy: Int
        get(){
            if(value == null) {
                value = initializer()
            }
            return value!!
        }
}