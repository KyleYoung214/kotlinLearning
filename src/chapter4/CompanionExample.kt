package chapter4

interface Nothing{
    fun doNothing()
}

class UserFactory private constructor(val nickName: String) {
    // no static but companion, can access private members of the class
    companion object Make:Nothing {
        fun newTypeAUser(email: String) = UserFactory(email.substringBefore('@'))

        fun newTypeBUser(id: String) = UserFactory(id)

        override fun doNothing() {

        }
    }
}

// java: UserFactory.Make.functions or UserFactory.Companion.functions

// or use @JvmStatic    @JvmField  wait to see chapter 10

fun main(args: Array<String>) {
    val typeAUser = UserFactory.Make.newTypeAUser("aaa@bbb.com")
    val typeBUser = UserFactory.newTypeBUser("id-1111")

    println(typeAUser.nickName)
    println(typeBUser.nickName)
}