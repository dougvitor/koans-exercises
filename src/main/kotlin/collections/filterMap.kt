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
    ), Customer(
        "Douglas",
        City("São Paulo"),
        listOf(Order(listOf(), true), Order(listOf(), false))
    ))

    val shop = Shop("Magazine", customers)
    val cities = shop.getCustomerCities()
    println(cities)

    println(shop.getCustomersFrom(cities.last()))
    println(shop.getCustomersFrom(cities.first()))

}

fun Shop.getCustomerCities(): Set<City> = customers.map { it.city }.toSet()

fun Shop.getCustomersFrom(city: City): List<Customer> =  customers.filter { it.city.name == city.name }