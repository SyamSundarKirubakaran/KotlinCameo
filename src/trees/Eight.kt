package trees

import trees.util.Node
import trees.util.constructBalancedTree

/**
 * @author SYAM K
 * @problem : Diameter of a Binary Tree
 */

fun main() {
    val head = constructBalancedTree()
    println(diameter(head, Height(0)))
}

/**
 *           1
 *       /       \
 *      2         3
 *    /   \     /  \
 *   4     5   6    7
 *  / \   / \ / \  / \
 */

private fun diameter(head: Node?, height: Height): Int {
    val leftHeight = Height(0)
    val rightHeight = Height(0)
    if (head == null) {
        height.height = 0
        return 0
    }
    val leftDiameter = diameter(head.left, leftHeight)
    val rightDiameter = diameter(head.right, rightHeight)
    height.height = Math.max(leftHeight.height, rightHeight.height) + 1
    return Math.max(
        leftHeight.height + rightHeight.height + 1,
        Math.max(leftDiameter, rightDiameter)
    )
}

internal class Height(var height: Int)
