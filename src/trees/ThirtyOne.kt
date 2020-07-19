package trees

import trees.util.Node
import trees.util.constructBalancedTree
import java.util.*

/**
 * @author SYAM K
 * @problem : Multiplication of Sums of data at each level
 */

fun main() {
    val head = constructBalancedTree()
    println(sumAndMultiplyLevelData(head))
}

/**
 *           1           -> 1
 *       /       \
 *      2         3      -> 5
 *    /   \     /  \
 *   4     5   6    7    -> 22
 *  / \   / \ / \  / \
 *
 *  110
 */

fun sumAndMultiplyLevelData(head: Node?): Int {
    if (head == null) return 0
    var result = 1
    val queue: LinkedList<Node> = LinkedList()
    queue.addLast(head)
    while (true) {
        var nodeCount = queue.size
        if (nodeCount == 0) {
            break
        }
        var sum = 0
        while (nodeCount > 0) {
            val (value, left, right) = queue.poll()
            sum += value
            if (left != null) queue.addLast(left)
            if (right != null) queue.addLast(right)
            nodeCount -= 1
        }
        result *= sum
    }
    return result
}