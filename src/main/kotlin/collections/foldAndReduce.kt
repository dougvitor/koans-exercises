package collections

fun main() {

    val numbers = listOf(5, 2, 10, 4)

    val sum = numbers.reduce { sum, element -> sum + element }
    println(sum)
    val sumDoubled = numbers.fold(0) { sum, element -> sum + element * 2 }
    println(sumDoubled)

    val sumDoubledReduce = numbers.reduce { sum, element -> sum + element * 2 }
    println(sumDoubledReduce)

    val customers =  listOf(
        Customer(
            "Catia",
            City("Maceio"),
            listOf(Order(listOf(Product("PS5", 10000.0), Product("RTX 3070", 9900.0)), true))
        ), Customer(
            "Joana",
            City("São Paulo"),
            listOf(Order(listOf(Product("RTX 3070", 9900.0)), false), Order(listOf(Product("Ryzen 9", 6900.0)), false), Order(listOf(Product("Tablet A7", 1500.0)), true))
        ), Customer(
            "Douglas",
            City("São Paulo"),
            listOf(Order(listOf(Product("Tablet A7", 1500.0)), true), Order(listOf(Product("Dell Latitude 7410", 13000.0), Product("RTX 3070", 9900.0)), false))
        ))

    val shop = Shop("Magazine", customers)
    println(shop.getProductsOrderedByAll())


}

fun Shop.getProductsOrderedByAll(): Set<Product> {
    val allOrders: List<Order> = customers.flatMap { it.orders }
    val allProducts: Set<Product> = customers.flatMap { allOrders.flatMap(Order::products) }.toSet()

    return customers.fold(allProducts) { orderedByAll, customer ->
        orderedByAll.intersect(customer.getOrderedProducts())
    }
}



