package trees

/**
 * @author SYAM K
 * @problem : Size of a binary tree
 */

data class Node(
    val value: Int,
    val left: Node? = null,
    val right: Node? = null
)

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

/**
 *          1
 *       /     \
 *      2       3
 *    /   \    / \
 *   4     5
 *  / \   / \
 */

fun constructTree(): Node {
    return Node(
        value = 1,
        left = Node(
            value = 2,
            left = Node(
                value = 4
            ),
            right = Node(
                value = 5
            )
        ),
        right = Node(
            value = 3
        )
    )
}

