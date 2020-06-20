package ds

import trees.util.Node
import trees.util.constructTree

/**
 * @author SYAM K
 * @problem : Tree Traversals
 */

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
