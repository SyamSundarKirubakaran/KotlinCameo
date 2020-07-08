package trees

import trees.util.Node
import trees.util.constructBalancedTree

/**
 * @author SYAM K
 * @problem : Cousin nodes or not
 */

fun main() {
    val head = constructBalancedTree()
    val newNode1 = Node(value = 5)
    val newNode2 = Node(value = 4)
    println(cousin(head, newNode1, newNode2))
}

/**
 *           1
 *       /       \
 *      2         3
 *    /   \     /  \
 *   4     5   6    7
 *  / \   / \ / \  / \
 */

fun cousin(node: Node, one: Node, two: Node): Boolean {
    return level(node, one, 1) == level(node, two, 1) && !sibling(node, one, two)
}

fun sibling(node: Node, one: Node, two: Node): Boolean {
    return if(node.left == null || node.right == null) false
    else node.left!!.value == one.value && node.right!!.value == two.value ||
            node.right!!.value == one.value && node.left!!.value == two.value ||
            sibling(node.left!!, one, two) ||
            sibling(node.right!!, one, two)
}

fun level(node: Node?, searchNode: Node, level: Int): Int {
    if (node == null) return 0
    if (node.value == searchNode.value) return level
    val left = level(node.left, searchNode, level + 1)
    return if (left != 0) left else level(node.right, searchNode, level + 1)
}