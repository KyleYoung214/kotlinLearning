package chapter4

class Someone(val name: String) {
    var address: String = "unspecified"
        set(value) {
            println("$name is living at/in/on $value")
            field = value
        }
}


class LengthCounter {
    var counter: Int = 0
        private set      // cannot modify outside the class

    fun add() {
        counter++;
    }
}

fun main(args: Array<String>) {
    val someone = Someone("kyle")
    someone.address = "Beijing"

    val lengthCounter = LengthCounter()
//    lengthCounter.counter = 5
    lengthCounter.add()
    println(lengthCounter.counter)
}