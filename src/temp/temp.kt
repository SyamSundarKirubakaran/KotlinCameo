package temp

import trees.util.Node
import java.util.*

/**
 * @author SYAM K
 * @problem : Temp File for Practice before creating youtube video
 */

private val s1: Stack<Node> = Stack<Node>()
private val s2: Stack<Node> = Stack<Node>()

fun printSpiral(node: Node?) {
    if (node != null) {
        s1.push(node)
        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                val (value, left, right) = s1.pop()
                println(value)
                if (right != null) s2.push(right)
                if (left != null) s2.push(left)
            }
            while (!s2.isEmpty()) {
                val (value, left, right) = s2.pop()
                println(value)
                if (left != null) s1.push(left)
                if (right != null) s1.push(right)
            }
        }
    }
}