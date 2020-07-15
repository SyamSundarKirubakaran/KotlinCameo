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

data class SNode(
    var value: String,
    var left: SNode? = null,
    var right: SNode? = null
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
 *    1
 *   / \
 *      2
 *     / \
 *        4
 *       / \
 */
fun skewedTree(): Node {
    return Node(
        value = 1,
        right = Node(
            value = 2,
            right = Node(
                value = 4
            )
        )
    )
}

/**
 *      2
 *    /   \
 *   4     5
 *  / \   / \
 */

fun constructSubTree(): Node {
    return Node(
        value = 2,
        left = Node(
            value = 4
        ),
        right = Node(
            value = 5
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


/**
 *           50
 *       /       \
 *      15       10
 *    /   \     /  \
 *   10    5   7    3
 *  / \   / \ / \  / \
 */

fun constructSumTree(): Node {
    return Node(
        value = 50,
        left = Node(
            value = 15,
            left = Node(
                value = 10
            ),
            right = Node(
                value = 5
            )
        ),
        right = Node(
            value = 10,
            left = Node(
                value = 7
            ),
            right = Node(
                value = 3
            )
        )
    )
}

/**
 *           +
 *       /       \
 *      *        *
 *    /   \     /  \
 *   1     2   3    4
 *  / \   / \ / \  / \
 */

fun constructExpressionTree(): SNode {
    return SNode(
        value = "+",
        left = SNode(
            value = "*",
            left = SNode(
                value = "1"
            ),
            right = SNode(
                value = "2"
            )
        ),
        right = SNode(
            value = "*",
            left = SNode(
                value = "3"
            ),
            right = SNode(
                value = "4"
            )
        )
    )
}