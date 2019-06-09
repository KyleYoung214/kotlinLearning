package chapter7

import kotlin.reflect.KProperty

// https://www.runoob.com/kotlin/kotlin-delegated.html

class Example {
    var p: String by Delegate()
}

class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, here delegate the ${property.name}"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$thisRef 's ${property.name} is $value")
    }
}

fun main(args: Array<String>) {
    val e = Example()
    println(e.p)

    e.p = "olaolaola"
    println(e.p)
}