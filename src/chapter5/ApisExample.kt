package chapter5

fun main(args: Array<String>) {
    val list = listOf(1, 2, 3, 4)
    println(list.filter { it % 2 == 0 })

    println(list.map { it * it })

    val people = listOf(Person("Alice", 27), Person("Bob", 31), Person("Kate", 45), Person("Will", 45))
    println(people.map { it.name })

    println(people.filter { it.age > 30 }.map { it.name })

    // people.filter { it.age == people.maxBy(Person::age)?.age } // maxBy execute every time
    val maxAge = people.maxBy(Person::age)?.age
    val maxAgePeople = people.filter { it.age == maxAge }
    println(maxAgePeople)

    println(people.find { it.age == 45 }) // find first

    val canBeInClub27 = { p: Person -> p.age <= 27 }
    println(people.count(canBeInClub27))// without generate a map
    println(people.filter(canBeInClub27).size)

    // Map<Int, List<Person>>
    println(people.groupBy { it.age }) // {27=[Person(name=Alice, age=27)], 31=[Person(name=Bob, age=31)], 45=[Person(name=Kate, age=45), Person(name=Will, age=45)]}

    println(people.all(canBeInClub27)) // false

    println(people.any(canBeInClub27)) // true

    // !all + 条件 可以用 any +这个条件取反替换
    println(!list.all { it == 3 }) // true
    println(list.any { it != 3 })  // true

    val strings = listOf("abc", "def")
    println(strings.flatMap { it.toList() }) // [a, b, c, d, e, f]

    val listOfList = listOf(listOf(1, 2, 3, 4), listOf(6, 7, 8, 9))
    println(listOfList.flatten()) // [1, 2, 3, 4, 6, 7, 8, 9]

    people.map(Person::name).filter { it.startsWith("A") } // filter and map will separately return a list
    people.asSequence()
            .map(Person::name)
            .filter { it.startsWith("A") }
            .toList()

    println(people.asSequence().map(Person::name).filter { it.length >= 4 }.toList())
    println(people.asSequence().filter { it.name.length >= 4 }.map(Person::age).toList()) // better

    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    println(numbersTo100.sum()) // 5050

    // java void postponeComputation(int delay, Runnable runnable)
    JavaMethod.postponeComputation(100) { println("runnable") } // only create one runnable
    val runnable = { println("only one runnable") }
    JavaMethod.postponeComputation(101, runnable) // like the upper one

    // not inline kotlin functions ??
    JavaMethod.postponeComputation(1000, object : Runnable { // new runnable every time called
        override fun run() {
            println("every time create a new runnable")
        }
    })

    createAllDoneRunnable().run()
    Thread(createAllDoneRunnable()).start()
}

// SAM
fun createAllDoneRunnable(): Runnable {
    return Runnable { println("${Thread.currentThread().id} All done") }
}

