package collections

fun main() {

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

    println(findMostExpensiveProductBy(Customer(
        "Douglas",
        City("São Paulo"),
        listOf(Order(listOf(Product("Tablet A7", 1500.0)), true),
            Order(listOf(Product("Dell Latitude 7410", 13000.0), Product("RTX 3070", 9900.0)), false),
            Order(listOf(Product("Ryzen 9", 6900.0)), true))
    )))

    println(shop.getNumberOfTimesProductWasOrdered(Product("RTX 3070", 9900.0)))

}

fun findMostExpensiveProductBy(customer: Customer): Product? {
    return  customer
            .orders
            .filter {it.isDelivered }
            .flatMap { it.products }
            .maxByOrNull { it.price }
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int{
    return customers.flatMap { it.getOrderedProducts() }.count { it == product}
}

