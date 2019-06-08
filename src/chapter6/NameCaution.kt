package chapter6

fun printInUpperCase(list: List<String>) {
    println(CollectionUtils.uppercaseAll(list))
    println(list.first())
}

fun main(args: Array<String>) {
    val list = listOf("a", "b", "c")
    printInUpperCase(list)

    println("after call method, list is: $list") // after call method, list is: [A, B, C]
    // so there should use MutableList instead of List

    println(toLowerCase(list.toMutableList()))

    // Arrays
    val letters = Array<String>(26) { i -> ('a' + i).toString() }
    println(letters.joinToString("")) // abcdefghijklmnopqrstuvwxyz

    val strings = listOf("a", "b", "c")
    println("%s/%s/%s".format(*strings.toTypedArray())) // list -> vararg

    fail("Error occurred")
}

fun toLowerCase(list: MutableList<String>): MutableList<String> {
    list.forEachIndexed { index, s -> list[index] = s.toLowerCase() }
    return list
}

fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}