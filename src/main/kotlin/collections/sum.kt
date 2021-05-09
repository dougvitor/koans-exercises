package collections

fun main(){
    val customer = Customer(
        "Douglas",
        City("São Paulo"),
        listOf(
            Order(listOf(Product("Tablet A7", 1500.0)), true), Order(
                listOf(Product("Dell Latitude 7410", 13000.0)),
                false
            )
        ))

    println(moneySpendBy(customer))

}

fun moneySpendBy(customer: Customer): Double = customer.orders.flatMap(Order::products).sumByDouble(Product::price)