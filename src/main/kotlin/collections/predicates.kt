package collections

fun main(){
    val customers =  listOf(
        Customer(
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
    val city = shop.getCustomerCities().find { it.name == "São Paulo" }

    city?.let {
        with(shop){
            println( checkAllCustomersAreFrom(city))
            println(hasCustomerFrom(city))
            println(countCustomersFrom(city))
            println(findCustomerFrom(city))
            println(findLastCustomerFrom(city))
        }
    }

}

fun Shop.checkAllCustomersAreFrom(city: City):Boolean = customers.all { it.city == city }

fun Shop.hasCustomerFrom(city: City): Boolean = customers.any{ it.city == city}

fun Shop.countCustomersFrom(city: City): Int = customers.count { it.city == city }

fun Shop.findCustomerFrom(city: City): Customer? = customers.find { it.city == city }

fun Shop.findLastCustomerFrom(city: City): Customer? = customers.findLast { it.city == city }