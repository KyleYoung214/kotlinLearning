package chapter3

fun main(args: Array<String>) {
    val string = "test"
    println(string.lalala)
    string.repeatVal = 3
    println(string * 5)

    val myProperty = MyProperty("kyle", 111)
    println(myProperty)
    myProperty.newProperty = "Kyle214"
    println("after set newProperty: $myProperty")
}

operator fun String.times(int: Int): String {
    val stringBuilder = StringBuilder()
    for (i in 0 until int) {
        stringBuilder.append(this)
    }
    return stringBuilder.toString()
}

val String.lalala: String
    get() = "lalala"

var String.repeatVal: Int
    set(value) {
        println("try to set $value, but no field to store here")
    }
    get() = 2

data class MyProperty(var property1: String, var proterty2: Int)

var MyProperty.newProperty: String
    set(value) {
        property1 = value
    }
    get() = property1