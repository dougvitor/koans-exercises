package collections

fun main(){
    val customers =  listOf(
        Customer(
            "Catia",
            City("Maceio"),
            listOf(Order(listOf(Product("PS5", 10000.0)), true))
        ), Customer(
            "Joana",
            City("São Paulo"),
            listOf(Order(listOf(Product("RTX 3070", 9900.0)), true), Order(listOf(Product("Ryzen 9", 6900.0)), false))
        ), Customer(
            "Douglas",
            City("São Paulo"),
            listOf(Order(listOf(Product("Tablet A7", 1500.0)), true), Order(listOf(Product("Dell Latitude 7410", 13000.0)), false))
        ))

    val shop = Shop("Magazine", customers)
    val customer = shop.getCustomerWithMaxOrders()
    println(customer)
    println(customer?.orders?.flatMap(Order::products) )
    println(shop.getMostExpensiveProductBy(customer!!))
    println(shop.getMostCheapProductBy(customer!!))

}

fun Shop.getCustomerWithMaxOrders(): Customer? = customers.maxByOrNull { it.orders.size }

fun Shop.getMostExpensiveProductBy(customer: Customer): Product? = customer.orders.flatMap(Order::products).maxByOrNull(Product::price)

fun Shop.getMostCheapProductBy(customer: Customer): Product? = customer.orders.flatMap(Order::products).minByOrNull(Product::price)





