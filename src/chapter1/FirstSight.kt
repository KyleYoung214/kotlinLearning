package chapter1

data class Person(val name: String, val age: Int? = null)

fun main(args: Array<String>) {
    val persons = listOf(Person("Kyle214"), Person("KyleYoung", 11))

    val oldest = persons.maxBy { it.age ?: 0 }
    println("the oldest is: $oldest")
    // the oldest is: Person(name=KyleYoung, age=11)
}