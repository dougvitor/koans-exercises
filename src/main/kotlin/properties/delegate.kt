package properties

import conventions.MyDate
import java.util.*

fun main(){
    val lazyPropertyDelegate = LazyPropertyDelegate {
        30
    }
    println(lazyPropertyDelegate.lazyValue)
}

class LazyPropertyDelegate(initializer: () -> Int){
    val lazyValue: Int by lazy(initializer)
}

