package builders

fun main(){
    println(createTable())
}

open class Tag(val name: String){
    protected val children = mutableListOf<Tag>()

    override fun toString(): String = "<$name>${children.joinToString("")}</$name>"
}

class TD : Tag("td")

class TR : Tag("tr"){
    fun td(init: TD.() -> Unit){
        children += TD().apply(init)
    }
}

class TABLE : Tag("table"){
    fun tr(init: TR.() -> Unit){
        val tr = TR()
        tr.init()
        children += tr
    }
}

fun table(init: TABLE.() -> Unit): TABLE{
    val table = TABLE()
    table.init()
    return table
}

fun createTable() = table{
    tr {
        repeat(2){
            td{

            }
        }
    }
}



