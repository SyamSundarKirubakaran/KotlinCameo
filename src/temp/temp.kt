package temp

import trees.util.Node
import java.util.*

/**
 * @author SYAM K
 * @problem : Temp File for Practice before creating youtube video
 */

fun findNextRight(head: Node?, k: Int): Node? {
    if(head == null) return null
    val qn: Queue<Node> = LinkedList()
    val ql: Queue<Int> = LinkedList()

    var level = 0
    qn.add(head)
    ql.add(level)
    while (qn.isNotEmpty()){
        val node = qn.remove()
        level = ql.remove()
        if(node.value == k){
            return if (ql.isEmpty() || ql.peek() != level) null else qn.peek()
        }
        if(node.left != null){
            qn.add(node.left)
            ql.add(level + 1)
        }
        if(node.right != null){
            qn.add(node.right)
            ql.add(level + 1)
        }
    }
    return null
}