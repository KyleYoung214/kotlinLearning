package chapter2

import java.io.BufferedReader
import java.util.*

fun main(args: Array<String>) {
    val name = if (args.isNotEmpty()) args[0] else "World"
    println("Hello, $name!")

    val string = "string"
    println(string is String)

    println(1..10) // 1..10
    println(1 until 10) // 1..9

    // 20,17,14,11,8,5,2,
    for (i in 20 downTo 1 step 3) {
        print("$i,")
    }
    println()

    val binaryReps = TreeMap<Char, String>()
    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary   // map[key] = value, in java map.put(key, value)
    }

    for ((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }

    val list = arrayListOf("10", "11", "1001")
    for ((index, element) in list.withIndex()) {
        println("$index: $element")
    }

    val number = 99
    val percentage = if (number in 0..10) number else
        throw IllegalArgumentException("wrong percentage: $number")
}

fun max(a: Int, b: Int) = if (a > b) a else b // if 是表达式不是语句

class Person(val name: String, var isMarried: Boolean)

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() = height == width
}

enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0), GREEN(0, 255, 0), BLUE(0, 0, 255), YELLOW(255, 255, 0);

    fun rgb() = (r * 256 + g) * 256 + b
}

fun getColorMeaning(color: Color) =
        when (color) {
            Color.RED -> "Rich"
            Color.GREEN, Color.YELLOW -> "Great"
            else -> "Better"
        }

// too many instances of set
fun getMix(c1: Color, c2: Color) =
        when (setOf(c1, c2)) {
            setOf(Color.RED, Color.BLUE) -> "red and blue"
            setOf(Color.BLUE, Color.YELLOW) -> "blue and yellow"
            else -> "else"
        }

fun getMixOptimized(c1: Color, c2: Color) =
        when {
            (c1 == Color.RED && c2 == Color.BLUE) ||
                    (c1 == Color.BLUE && c2 == Color.RED) -> "red and blue"
            (c1 == Color.BLUE && c2 == Color.YELLOW) ||
                    (c1 == Color.YELLOW && c2 == Color.BLUE) -> "blue and yellow"
            else -> "else"
        }

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'

// kotlin 不区分受检异常和未受检异常
fun readNumber(reader: BufferedReader): Int? {// 不必显示制定函数可能抛出的异常
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    } catch (e: NumberFormatException) {
        return null
    } finally {
        reader.close()
    }
}
