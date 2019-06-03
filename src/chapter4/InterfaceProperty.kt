package chapter4

interface User {
    val email: String
    val nickName: String
        get() = email.substringBefore('@')
}

class SubscribingUser(val userEmail: String) : User {
    override val email = userEmail // email must be override
}


fun main(args: Array<String>) {
    val user = SubscribingUser("sendtokyle@foxmail.com")
    println(user.email)
    println(user.nickName)
}