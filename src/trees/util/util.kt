package trees.util

/**
 * @author SYAM K
 * @problem : Utility functions for Kotlin Trees
 */

data class Node(
    val value: Int,
    val left: Node? = null,
    val right: Node? = null
)

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

