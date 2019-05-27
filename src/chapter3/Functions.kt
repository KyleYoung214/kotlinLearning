package chapter3

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
}

@JvmOverloads // java 没有参数默认值，加注解从最后一个开始省略参数进行重载
fun testDefaultParams(string: String = "haha", value: Int = 0) {}