package trees

import trees.util.Node
import trees.util.constructBST

/**
 * @author SYAM K
 * @problem : Lowest Common Ancestor - BST
 */

fun main() {
    val head = constructBST()
    println(lca(head, 1, 3)?.value)
}


/**
 *           4
 *       /       \
 *      2         6
 *    /   \     /  \
 *   1     3   5    7
 *  / \   / \ / \  / \
 */

fun lca(head: Node?, p: Int, q: Int): Node? {
    head?.let {
        if (p < head.value && q < head.value) {
            return lca(head.left, p, q)
        }
        if (p > head.value && q > head.value) {
            return lca(head.right, p, q)
        }
    }
    return head
}
