package chapter7

import java.time.LocalDate

data class Point(val x: Int, val y: Int) : Comparable<Point> {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }

    override fun equals(other: Any?): Boolean {
        if (other === this) {
            return true
        }

        if (other !is Point) {
            return false
        }

        return x == other.x && y == other.y // smart cast
    }

    override fun hashCode(): Int {
        return x.hashCode() + y.hashCode()
    }

    // 先x再y
    override fun compareTo(other: Point): Int {
        return compareValuesBy(this, other, Point::x, Point::y)
    }
}

data class Rectangle(val upperLeft: Point, val lowerRight: Point)

class NotDataClass(val x: Int, val y: Int) {
    operator fun component1() = x
    operator fun component2() = y
}


fun main(args: Array<String>) {
    var p1 = Point(20, 30)
    val p2 = Point(50, 80)
    println(p1 + p2)  // Point(x=70, y=110)
    println(p1 * 1.5) // Point(x=30, y=45)

    p1 += Point(1, 2)
    println(p1) // Point(x=21, y=32)

    println(-p1) // Point(x=-21, y=-32)

    println(p1 > p2) // false
    println(p1.compareTo(-p1)) // 1

    println(p1[1]) // 32

    val rect = Rectangle(Point(0, 0), Point(100, 200))
    println(p1 in rect) // means rect contains p1,  true

    val list = arrayListOf(1, 2)
    list += 3
    val newList = list + listOf(4, 5)
    println(list) // [1, 2, 3]
    println(newList) // [1, 2, 3, 4, 5]

    val now = LocalDate.now()
    val vacation = now..now.plusDays(10)
    println(now in vacation) // true

    (0..10).forEach { print(it) } // 012345678910
    println()

    val newYear = LocalDate.ofYearDay(2019, 1)
    val daysOff = newYear.minusDays(1)..newYear
    for (dayOff in daysOff) {
        println(dayOff)
    }

    val (a, b) = p1
    println(a)
    println(b)
    val a1 = p1.component1()
    val a2 = p1.component2()
}

operator fun Point.times(scales: Double): Point {
    return Point((x * scales).toInt(), (y * scales).toInt())
}

// times div mod plus minus
// plusAssign minusAssign timesAssign

// unaryPlus +a, unaryMinus -a, !a not, ++a/a++ inc, --a/a-- dec
operator fun Point.unaryMinus(): Point {
    return Point(-x, -y)
}

operator fun Point.get(index: Int): Int {
    return when (index) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

operator fun Rectangle.contains(p: Point): Boolean {
    return p.x in upperLeft.x until lowerRight.x && p.y in upperLeft.y until lowerRight.y
}

operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =
        object : Iterator<LocalDate> {
            var current = start
            override fun hasNext() = current <= endInclusive
            override fun next() = current.apply { current = plusDays(1) }
        }