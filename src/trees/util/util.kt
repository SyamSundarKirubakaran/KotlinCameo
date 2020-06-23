package trees.util

/**
 * @author SYAM K
 * @problem : Utility functions for Kotlin Trees
 */

data class Node(
    var value: Int,
    var left: Node? = null,
    var right: Node? = null
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

/**
 *           1
 *       /       \
 *      2         3
 *    /   \     /  \
 *   4     5   6    7
 *  / \   / \ / \  / \
 */

fun constructBalancedTree(): Node {
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
            value = 3,
            left = Node(
                value = 6
            ),
            right = Node(
                value = 7
            )
        )
    )
}


/**
 *           4
 *       /       \
 *      2         6
 *    /   \     /  \
 *   1     3   5    7
 *  / \   / \ / \  / \
 */

fun constructBST(): Node {
    return Node(
        value = 4,
        left = Node(
            value = 2,
            left = Node(
                value = 1
            ),
            right = Node(
                value = 3
            )
        ),
        right = Node(
            value = 6,
            left = Node(
                value = 5
            ),
            right = Node(
                value = 7
            )
        )
    )
}

