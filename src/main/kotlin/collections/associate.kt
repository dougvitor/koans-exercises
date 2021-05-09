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

    println(shop.nameToCustomerMap())
    println(shop.customerToCityMap())
    println(shop.customerNameToCityMap())


}

fun Shop.nameToCustomerMap(): Map<String, Customer> = customers.associateBy { it.name }

fun Shop.customerToCityMap(): Map<Customer, City> = customers.associateWith (Customer::city)

fun Shop.customerNameToCityMap(): Map<String, City> = customers.associate { it.name to it.city }