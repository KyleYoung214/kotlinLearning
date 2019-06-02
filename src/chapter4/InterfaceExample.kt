package chapter4


// interfaces cannot have states
interface Clickable {
    fun click()
    fun showOff() = println("i'm clickable") // like in java 8, default implementation
}

interface Focusable {
    fun setFocus(b: Boolean) = println("i ${if (b) "got" else "lost"} focus")

    fun showOff() = println("im focusable")
}


class Button : Clickable, Focusable {
    var text: String? = null// default is public

    override fun click() = println("i was clicked")

    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}

fun main(args: Array<String>) {
    val button = Button()
    button.setFocus(true)
    button.showOff()
    button.click()

    /*
    i got focus
    i'm clickable
    im focusable
    i was clicked
     */
}