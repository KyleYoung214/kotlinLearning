package chapter3

import chapter3.getLastChar as last

fun main(args: Array<String>) {


    val set = hashSetOf(1, 7, 7, 53)
    val list = arrayListOf(1, 2, 3, 7, 8)
    val map = hashMapOf(1 to "one", 7 to "seven", 8 to "eight")

    println(set.javaClass)
    println(set)
    println(list.javaClass)
    println(list)  // [1, 2, 3, 7, 8]
    println(list.joinToString(separator = "-", prefix = "<", postfix = ">")) // <1-2-3-7-8>
    println(map.javaClass)
    println(map)

    println(set.max())   // 53
    println(list.last()) // 8

    println(appendComma("hahaha")) //hahaha,

    println("show me the money".lastChar()) // y
    println("StarCraft".last())  // t
    println("last".theLastChar)  // t

    val intArray = list.toIntArray()
    testVarargs("haha->", *intArray) // *intArray *展开运算符

    val pair = Pair(4, "four")
    val (kk, vv) = Pair(5, "five")  // 解构声明

    val testRegdx = "12.345-6.A"
    println(testRegdx.split(".", "-")) // [12, 345, 6, A]
    println(testRegdx.split("\\.|-".toRegex()))  // [12, 345, 6, A]

    val fullPath = "/aaa/bbb/ccc/kyle.kt"
    val directory = fullPath.substringBeforeLast("/")
    val fullFileName = fullPath.substringAfterLast("/")
    val fileName = fullFileName.substringBeforeLast(".")
    val fileType = fullFileName.substringAfterLast(".")
    // /aaa/bbb/ccc, kyle.kt, name:kyle, ext:kt
    println("$directory, $fullFileName, name:$fileName, ext:$fileType")

    val trimQuote = """
        first line,$fileName
        second line\n, $ , $99.9,  ${'$'}999.9
        /.*|\{}
    """.trimIndent()

    /*
    first line,kyle
    second line\n, $ , $99.9,  $999.9
    /.*|\{}
     */
    println(trimQuote)
}

@JvmOverloads // java 没有参数默认值，加注解从最后一个开始省略参数进行重载
fun testDefaultParams(string: String = "haha", value: Int = 0) {
}


fun testVarargs(string: String = "args:", vararg values: Int) {
    println(string + values.size)
}