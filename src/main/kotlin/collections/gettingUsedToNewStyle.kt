package collections

fun main(){
    val strings = listOf<String>(
        "Amarilla",
        "Tarjeta",
        "Campeão",
        "Fé",
        "Raça",
        "Torcida",
        "Casa",
        "Vidraça",
        "Prédio",
        "Moradia",
        "Rua",
        "Logradouro",
        "Final",
        "Cartão",
        "Credito",
        "Débito"
    )

    println(doSomethingWithCollection(strings))
}

fun doSomethingWithCollection(collection: Collection<String>): Collection<String>?{

    val groupsByLength = collection.groupBy { s -> s.length }
    println(groupsByLength)

    val maximumSizeOfGroup = groupsByLength.values.map { group -> group.size }.maxOrNull()
    println(maximumSizeOfGroup)

    return groupsByLength.values.firstOrNull { group -> group.size == maximumSizeOfGroup }
}