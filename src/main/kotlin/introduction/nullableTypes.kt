package introduction

fun main(){

    val cliente = Client(PersonalInfo("email@email.com"))
    sendMessageToClient(cliente, "Hello!! How are you?", object: Mailer{

        override fun sendMessage(email: String, message: String) {
            println("""
                    Destinatário: $email
                    Mensagem: $message
                """.trimIndent())
        }

    })

}

fun sendMessageToClient(
    client: Client?,
    message: String?,
    mailer: Mailer
){
    val email: String? = client?.personalInfo?.email

    if(email != null && message != null){
        mailer.sendMessage(email, message)
    }
}

class Client(val personalInfo: PersonalInfo)

class PersonalInfo(val email: String?)

interface Mailer{
    fun sendMessage(email: String, message: String)
}
