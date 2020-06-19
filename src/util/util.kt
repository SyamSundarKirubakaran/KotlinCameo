package util

/**
 * @author SYAM K
 * @problem : Utility Functions
 */

fun complexity(block: () -> Unit) {
    val start = System.nanoTime()
    block()
    val end = System.nanoTime()
    println()
    println("Runtime: ${(end - start) / 1.0e9} seconds")
}