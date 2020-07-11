package trees

import trees.util.Node
import trees.util.constructBalancedTree
import java.util.*

/**
 * @author SYAM K
 * @problem : Print all paths possible from root to all leaves
 */

private var list: LinkedList<Int> = LinkedList()

fun main() {
    val head = constructBalancedTree()
    findPaths(head, 0)
}

/**
 *           1
 *       /       \
 *      2         3
 *    /   \     /  \
 *   4     5   6    7
 *  / \   / \ / \  / \
 */

fun findPaths(head: Node?, index: Int) {
    var index = index
    if (head != null) {
        list.add(index, head.value)
        index += 1
        if(isLeaf(head))
            printList(list, index)
        else {
            findPaths(head.left, index)
            findPaths(head.right, index)
        }
    }
}

fun printList(list: LinkedList<Int>, index: Int) {
    for (i in 0 until index) {
        print(list[i].toString() + " ")
    }
    println()
}

fun isLeaf(head: Node): Boolean {
    return head.left == null && head.right == null
}