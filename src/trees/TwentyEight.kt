package trees

import trees.util.Node
import trees.util.constructBalancedTree
import java.util.*

/**
 * @author SYAM K
 * @problem : Extreme nodes on each level in alternating order
 */

private var queue: LinkedList<Node> = LinkedList<Node>()

fun main() {
    val head = constructBalancedTree()
    printExtremeNodes(head)
}

/**
 *           1
 *       /       \
 *      2         3
 *    /   \     /  \
 *   4     5   6    7
 *  / \   / \ / \  / \
 */

fun printExtremeNodes(head: Node?) {
    if(head == null) return
    queue.addLast(head)
    var flag = true
    while (queue.isNotEmpty()){
        val nodeCount = queue.size
        var n = nodeCount
        while (n-- > 0){
            val temp = queue.peek()
            if(temp.left != null) queue.addLast(temp.left)
            if(temp.right != null) queue.addLast(temp.right)
            queue.remove()
            if(!flag && n==0) println(temp.value)
            if(flag && n == nodeCount - 1) println(temp.value)
        }
        flag = !flag
    }
}