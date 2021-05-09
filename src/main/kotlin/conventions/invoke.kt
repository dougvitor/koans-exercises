package conventions

fun main(){
    invokeTwice(Invokable())
}

class Invokable{

    var numberOfInvocations: Int = 0
        private set
    operator fun invoke(): Invokable{
        print(++numberOfInvocations)
        return this
    }
}

fun invokeTwice(invokable: Invokable) = invokable()()
