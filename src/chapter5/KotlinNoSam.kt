package chapter5

interface KotlinInterface {
    open fun callMethod()
}


typealias KotlinInterface2 = (Unit) -> Unit


fun main(args: Array<String>) {
    val test1 = JavaSAM {
        println("calling java SAM by lambda")
    }

//    val test2 = KotlinInterface {
//        println("cannot compile")
//    }

    val test3 = object : KotlinInterface {
        override fun callMethod() {
            println("this one is correct")
        }
    }

}