package chapter6

fun strLenNotSafe(s: String) = s.length

fun strLenSafe(s: String?) = s?.length ?: 0

open class OpenPerson(val name: String, val age: Int? = null) {
    private lateinit var friend: OpenPerson

    override fun equals(other: Any?): Boolean {
        val otherPerson = other as? OpenPerson ?: return false
        return otherPerson.name == name && otherPerson.age == age
    }

    override fun hashCode(): Int = name.hashCode() * 37 + (age?.hashCode() ?: 0)

    fun isOlderThan(other: OpenPerson): Boolean? {
        if (age == null || other.age == null) {
            return null
        }
        return age > other.age
    }
}

fun main(args: Array<String>) {
    var s: String? = null
    s?.let { it: String -> strLenNotSafe(it) }

    s = "  "
    println(s.isNullOrEmpty()) // false
    println(s.isNullOrBlank()) // true

    // strLenNotSafe(s!!) // KotlinNullPointerException

    val person = OpenPerson("AAA", 22)

    val x = 1
    val list = listOf(1L, 2L, 3L)
    println(x.toLong() in list)

    val valueCouldBeNull: List<Int?> = listOf(1, 2, null, 3, 4, null, 5)
    val listCouldBeNull: List<Int>?
    val bothCouldBeNull: List<Int?>?
    println(valueCouldBeNull.filterNotNull()) // [1, 2, 3, 4, 5]


}

fun <T> printHashCode(t: T) { // T can be Any?
    println(t?.hashCode())
}

fun <T : Any> printHashCode2(t: T) {
    println(t.hashCode())
}

// in java
// @Nullable + type = type?
// @NotNull + type = type

fun <T> copyElements(source: Collection<T>, target: MutableCollection<T>) {
    for (item in source) {
        target.add(item)
    }
}