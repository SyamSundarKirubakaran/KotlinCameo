package temp

import trees.util.Node
import java.util.*

/**
 * @author SYAM K
 * @problem : Temp File for Practice before creating youtube video
 */

private var map: HashMap<Int, MutableList<Node>> = HashMap<Int, MutableList<Node>>()

fun performDiagonalTraversal(node: Node?, d: Int) {
    if (node == null) return
    val n = map[d]
    if (n == null) {
        val list = LinkedList<Node>()
        list.add(node)
        map[d] = list
    } else {
        n.add(node)
        map[d] = n
    }
    performDiagonalTraversal(node.left, d + 1)
    performDiagonalTraversal(node.right, d)
}