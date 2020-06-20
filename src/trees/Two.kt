package trees

import trees.util.Node
import trees.util.constructTree

/**
 * @author SYAM K
 * @problem : Is Identical
 */


fun main() {
    val head1 = constructTree()
    val head2 = constructTree()
    println(isIdentical(head1, head2))
}


/**
 *          1
 *       /     \
 *      2       3
 *    /   \    / \
 *   4     5
 *  / \   / \
 */

/**
 *          1
 *       /     \
 *      2       3
 *    /   \    / \
 *   4     5
 *  / \   / \
 */


fun isIdentical(head1: Node?, head2: Node?): Boolean {
    if (head1 == null && head2 == null) {
        return true
    }
    if (head1 != null && head2 != null) {
        return head1.value == head2.value &&
                isIdentical(head1.left, head2.left) &&
                isIdentical(head1.right, head2.right)
    }
    return false
}
