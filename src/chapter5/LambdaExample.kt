package chapter5

data class Person(val name: String, val age: Int)

fun main(args: Array<String>) {
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    println(people.maxBy { it.age }) // Person(name=Bob, age=31)
//    people.maxBy() { p: Person -> p.age }
//    people.maxBy { p: Person -> p.age }
//    people.maxBy { p -> p.age }

    // 成员引用，类::成员
    println(people.maxBy(Person::age))

    val names = people.joinToString(" ") { p: Person -> p.name }
    println(names) // ALice Bob

    printProblemCounts(listOf("200 OK", "418 ...", "500 internal server error"))

    run(::salute)

    val action = { person: Person, message: String -> sendEmail(person, message) }
    val action1 = ::sendEmail

    val createPerson = ::Person
    val p = createPerson("Kyle", 30)
    println(p)
    val predicate = Person::isAdult
    println(predicate(p))
    val isKyleAdult = p::isAdult
    println(isKyleAdult())
}

fun salute() = println("Salute!")

fun sendEmail(p: Person, message: String) {

}

fun Person.isAdult() = age >= 21

// Kotlin 允许在lambda内部访问非final变量甚至修改他们
fun printProblemCounts(response: Collection<String>) {
    var clientErrors = 0
    var serverErrors = 0
    response.forEach {
        // lambda中修改变量
        if (it.startsWith("4")) {
            clientErrors++
        } else if (it.startsWith("5")) {
            serverErrors++
        }
    }
    println("$clientErrors client errors, $serverErrors server errors")
}

// 原理
class Ref<T>(var value: T)

fun example() {
    val counter = Ref(0)
    val inc = { counter.value++ } // 形式上不变量，但是字段值可改变
}