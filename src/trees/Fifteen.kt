package trees

import trees.util.Node
import trees.util.constructBalancedTree

/**
 * @author SYAM K
 * @problem : Top View
 */

private var min: Int = Int.MAX_VALUE
private var max: Int = Int.Companion.MIN_VALUE
private val hash: LinkedHashMap<Int, Node> = LinkedHashMap()

fun main() {
    val head = constructBalancedTree()
    findTopView(head)
}

/**
 *           1
 *       /       \
 *      2         3
 *    /   \     /  \
 *   4     5   6    7
 *  / \   / \ / \  / \
 */

fun findTopView(head: Node) {
    getMinMax(head, 0)
    for (i in min..max) {
        inflateTopView(head, i, 0)
    }
    hash.forEach { (_, u) ->
        println(u.value)
    }
}

fun inflateTopView(head: Node?, lineNo: Int, hd: Int) {
    if (head == null) return
    if (lineNo == hd) hash.putIfAbsent(lineNo, head)
    inflateTopView(head.left, lineNo, hd - 1)
    inflateTopView(head.right, lineNo, hd + 1)
}

fun getMinMax(head: Node?, index: Int) {
    if (head == null) return
    if (index < min) min = index
    if (index > max) max = index
    getMinMax(head.left, index - 1)
    getMinMax(head.right, index + 1)
}