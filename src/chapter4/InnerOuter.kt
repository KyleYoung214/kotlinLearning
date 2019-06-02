package chapter4


/**
 * 类A在另一个类B中声明        在Java中          在Kotlin中
 * 嵌套类(不存储外部类引用)     static class A   classA
 * 内部类(存储外部类引用)       class A         inner class A
 */
class Outer {
    inner class inner {
        fun getOuterReference(): Outer = this@Outer
    }
}