package properties

import conventions.MyDate
import java.util.*
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun main(){
    val d = D()
    d.date =  MyDate(2020, 1, 6)
    println(d.date)
}

class D{
    var date: MyDate by EffectiveDate()
}

class EffectiveDate<R> : ReadWriteProperty<R, MyDate>{
    var timeInMillis: Long? = null

    override fun getValue(thisRef: R, property: KProperty<*>): MyDate {
        println("Use Delegate getValue")
        return timeInMillis!!.toDate()
    }

    override fun setValue(thisRef: R, property: KProperty<*>, value: MyDate) {
        println("Use Delegate setValue")
        timeInMillis = value.toMillis()
    }

}

fun MyDate.toMillis(): Long{
    val c = Calendar.getInstance()
    c.set(year, month, dayOfMonth)
    return c.timeInMillis
}

fun Long.toDate(): MyDate {
    val c = Calendar.getInstance()
    c.timeInMillis = this
    return MyDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE))
}