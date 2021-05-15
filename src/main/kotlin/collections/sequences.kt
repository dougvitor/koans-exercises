package collections

fun main(){

    val words = "The quick brown fox jumps over the lazy dog".split(" ")

    val lengthsList = words.filter {
        println("filter: $it")
        it.length > 3
    }.map {
        println("length: ${it.length}")
        it.length
    }.take(4)

    println("Lengths of firts 4 words longer than 3 chars: $lengthsList\n")

    val wordsSequence = words.asSequence()

    val lengthsSequence = wordsSequence.filter {
        println("filter: $it")
        it.length > 3
    }.map {
        println("length: ${it.length}")
        it.length
    }.take(4)

    println("Lengths of firts 4 words longer than 3 chars: ${lengthsSequence.toList()}\n")

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

    println(findSequenceMostExpensiveProductBy(Customer(
        "Douglas",
        City("São Paulo"),
        listOf(Order(listOf(Product("Tablet A7", 1500.0)), true),
            Order(listOf(Product("Dell Latitude 7410", 13000.0), Product("RTX 3070", 9900.0)), true),
            Order(listOf(Product("Ryzen 9", 6900.0)), true))
    )))

    println(shop.sequenceNumberOfTimesProductWasOrdered(Product("RTX 3070", 9900.0)))

}

fun findSequenceMostExpensiveProductBy(customer: Customer): Product?{
    return customer.orders.asSequence().filter { it.isDelivered }.flatMap { it.products }.maxByOrNull (Product::price)
}

fun Shop.sequenceNumberOfTimesProductWasOrdered(product: Product): Int{
    return customers.flatMap { it.getSequenceOrderProducts() }.count {it == product}
}

fun Customer.getSequenceOrderProducts(): Sequence<Product> = orders.flatMap(Order::products).asSequence()