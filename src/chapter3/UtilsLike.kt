@file:JvmName("StringFunctions")

// in java, call like StringFunctions.appendComma(..)

package chapter3


const val UNIX_LINE_SEPARATOR = "\n"
// in java, public static final String UNIX_LINE_SEPARATOR = "\n";

var opCount = 0 // top property


fun appendComma(string: String): String {
    return "$string,"
}