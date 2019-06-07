package chapter5

fun alphabet(): String {
    val result = StringBuilder()
    for (letter in 'A'..'Z') {
        result.append(letter)
    }
    result.append("\nNow I know the alphabet!")
    return result.toString()
}

fun simpleAlphabet(): String {
    val result = StringBuilder()
    return with(result) {
        for (letter in 'A'..'Z') {
            /*this.*/append(letter)
        }
        append("\nNow I know the simple way")
        /*this.*/toString()
    }
}

fun applyAlphabet() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow return the receiver object")
}.toString() // sb.toString()

fun stdlibAlphabet() = buildString {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow use the std function")
}