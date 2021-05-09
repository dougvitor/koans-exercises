package collections

fun main(){
    val customers =  listOf(Customer(
        "Catia",
        City("Maceio"),
        listOf(Order(listOf(), true))
    ), Customer(
        "Joana",
        City("São Paulo"),
        listOf(Order(listOf(), true), Order(listOf(), false))
    ))

    println(Shop("Magazine", customers).getCustomersSortedByOrders())

}

fun Shop.getCustomersSortedByOrders(): List<Customer> = customers.sortedByDescending { it.orders.size }