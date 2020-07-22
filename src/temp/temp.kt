package temp

import trees.util.Node
import java.util.*

/**
 * @author SYAM K
 * @problem : Temp File for Practice before creating youtube video
 */

private var serialResult: LinkedList<Node> = LinkedList<Node>()

fun deserialize(serialResult: LinkedList<Node>): Node? {
    var node: Node? = null
    if (serialResult.size > 0) {
        val popped = serialResult.removeFirst()
        node = if (popped.value != -1) popped else null
        deserialize(serialResult)
    }
    return node
}

fun serialize(node: Node?) {
    if (node == null) serialResult.addLast(Node(-1)) else {
        serialResult.addLast(node)
        serialize(node.left)
        serialize(node.right)
    }
}