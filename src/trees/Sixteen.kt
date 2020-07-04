package trees

import trees.util.Node
import trees.util.constructBalancedTree

/**
 * @author SYAM K
 * @problem : Bottom View of a Binary Tree
 */

private var min: Int = Int.MAX_VALUE
private var max: Int = Int.Companion.MIN_VALUE
private val hash: LinkedHashMap<Int, Node> = LinkedHashMap()

fun main() {
    val head = constructBalancedTree()
    findBottomView(head)
}

/**
 *           1
 *       /       \
 *      2         3
 *    /   \     /  \
 *   4     5   6    7
 *  / \   / \ / \  / \
 */

fun findBottomView(head: Node) {
    minMax(head, 0)
    for (i in min..max) {
        inflateBottomView(head, i, 0)
    }
    hash.forEach { (_, u) ->
        println(u.value)
    }
}

fun inflateBottomView(head: Node?, lineNo: Int, hd: Int) {
    if (head == null) return
    if (lineNo == hd) hash[lineNo] = head
    inflateBottomView(head.left, lineNo, hd - 1)
    inflateBottomView(head.right, lineNo, hd + 1)
}

fun minMax(head: Node?, index: Int) {
    if (head == null) return
    if (index < min) min = index
    if (index > max) max = index
    minMax(head.left, index - 1)
    minMax(head.right, index + 1)
}