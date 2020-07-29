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

data class NNode(
    var value: Int,
    var children: List<NNode> = listOf()
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
 *           55
 *       /        \
 *      10        25
 *    /   \     /    \
 *   9     4   3     11
 *  / \   / \ / \    / \
 *               4
 *              / \
 */

fun constructSumTreeInput(): Node {
    return Node(
        value = 55,
        left = Node(
            value = 10,
            left = Node(
                value = 9
            ),
            right = Node(
                value = 4
            )
        ),
        right = Node(
            value = 25,
            left = Node(
                value = 3,
                right = Node(
                    value = 4
                )
            ),
            right = Node(
                value = 11
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
 *           25
 *       /       \
 *      32       45
 *    /   \     /  \
 *   3     50  2   15
 *  / \   / \ / \  / \
 *       4      -5
 */

fun constructDiffTree(): Node {
    return Node(
        value = 25,
        left = Node(
            value = 32,
            left = Node(
                value = 3
            ),
            right = Node(
                value = 50,
                left = Node(
                    value = 4
                )
            )
        ),
        right = Node(
            value = 45,
            left = Node(
                value = 2,
                right = Node(
                    value = -5
                )
            ),
            right = Node(
                value = 15
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


/**
 *             0
 *        /     \    \
 *       1       2    3
 *    /  |  \     \    \
 *   4   5   6
 *   \    \   \
 */

fun constructNaryTree(): NNode {
    return NNode(
        value = 0,
        children = listOf(
            NNode(
                value = 1,
                children = listOf(
                    NNode(value = 4),
                    NNode(value = 5),
                    NNode(value = 6)
                )
            ),
            NNode(value = 2),
            NNode(value = 3)
        )
    )
}