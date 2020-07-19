package temp

import trees.util.Node
import java.util.*

/**
 * @author SYAM K
 * @problem : Temp File for Practice before creating youtube video
 */

fun sumAndMultiplyLevelData(node: Node?): Int {
    if (node == null) return 0
    var result = 1
    val queue: LinkedList<Node> = LinkedList<Node>()
    queue.add(node)
    while (true) {
        var nodeCount = queue.size
        if (nodeCount == 0)
            break
        var sum = 0
        while (nodeCount > 0) {
            val (value, left, right) = queue.poll()
            sum += value
            if (left != null) queue.add(left)
            if (right != null) queue.add(right)
            nodeCount -= 1
        }
        result *= sum
    }
    return result
}
