package chapter3

// java, FunctionsExt.function


// extend functions
fun String.lastChar(): Char = this.get(this.length - 1)

fun String.getLastChar(): Char = get(this.length - 1)

// extend property, FunctionExt.getTheLastChar(...)
val String.theLastChar: Char
    get() = get(length - 1)


open class View {
    open fun click() = println("view click")
}

class Button : View() {
    override fun click() = println("button click")
}


fun View.showOff() = println("i'm a view")

fun Button.showOff() = println("i'm a button")


fun main(args: Array<String>) {
    val view: View = Button()
    view.click()   // button click
    view.showOff() // i'm a view ----------> like static function
}

class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {
    fun validate(/*user: User,*/ value: String, field: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("${user.id} check failed") // 可以直接访问外部函数的参数
        }
    }

    validate(/*user, */user.name, "Name")
    validate(/*user, */user.address, "Address")
}

fun User.checkUser() {
    fun validate(value: String, field: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("$id: empty $field")
        }
    }

    validate(name, "Name")
    validate(address, "Address")
}

fun saverUser2(user: User) {
    user.checkUser()
}