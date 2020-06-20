package trees

import trees.util.Node
import trees.util.constructTree

/**
 * @author SYAM K
 * @problem : Size of a binary tree
 */

fun main() {
    val head = constructTree()
    println(findSize(head))
}

fun findSize(head: Node?): Int {
    return if (head == null) {
        0
    } else {
        1 + findSize(head.left) + findSize(head.right)
    }
}
