package ds

/**
 * @author SYAM K
 * @problem : Tree Traversals
 */

data class Node(
    val value: Int,
    val left: Node? = null,
    val right: Node? = null
)

fun main() {
    val head = constructTree()
    preOrderTraversal(head)
    println()
    inOrderTraversal(head)
    println()
    postOrderTraversal(head)
}

fun postOrderTraversal(head: Node?) {
    head?.let {
        postOrderTraversal(head.left)
        postOrderTraversal(head.right)
        print("${head.value} ")
    }
}

fun inOrderTraversal(head: Node?) {
    head?.let {
        inOrderTraversal(head.left)
        print("${head.value} ")
        inOrderTraversal(head.right)
    }
}

fun preOrderTraversal(head: Node?) {
    head?.let {
        print("${head.value} ")
        preOrderTraversal(head.left)
        preOrderTraversal(head.right)
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
