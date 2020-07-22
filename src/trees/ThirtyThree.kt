package trees

import ds.preOrderTraversal
import trees.util.Node
import trees.util.constructBalancedTree
import java.util.*

/**
 * @author SYAM K
 * @problem : Serialization and Deserialization BT
 */

// END MARKER = -1
private var serialResult: LinkedList<Node> = LinkedList<Node>()

fun main() {
    val head = constructBalancedTree()
    serialize(head)
    println(serialResult.map { it.value })
    val resultHead = deserialize(serialResult)
    preOrderTraversal(resultHead)
}

/**
 *           1
 *       /       \
 *      2         3
 *    /   \     /  \
 *   4     5   6    7
 *  / \   / \ / \  / \
 */

fun serialize(head: Node?) {
    if (head == null) serialResult.addLast(Node(-1)) else {
        serialResult.addLast(head)
        serialize(head.left)
        serialize(head.right)
    }
}

fun deserialize(serialResult: LinkedList<Node>): Node? {
    var head: Node? = null
    if (serialResult.size > 0) {
        val popped = serialResult.remove()
        head = if (popped.value != -1) popped else null
        deserialize(serialResult)
    }
    return head
}