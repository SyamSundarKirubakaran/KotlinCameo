package temp

import trees.util.NNode
import java.util.*

/**
 * @author SYAM K
 * @problem : Temp File for Practice before creating youtube video
 */

private var serialResult: LinkedList<NNode> = LinkedList()

fun serializeNary(head: NNode?) {
    if (head == null) serialResult.addLast(NNode(-1)) else {
        serialResult.addLast(head)
        for (child in head.children) {
            trees.serializeNary(child)
            trees.serializeNary(null)
        }
    }
}

fun deserializeNary(serialResult: LinkedList<NNode>): NNode? {
    var head: NNode? = null
    if (serialResult.size > 0) {
        val popped: NNode = serialResult.removeFirst()
        head = if (popped.value != -1) popped else null
        deserializeNary(serialResult)
    }
    return head
}