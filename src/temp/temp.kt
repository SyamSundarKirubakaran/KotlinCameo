package temp

import trees.util.Node
import java.util.*

/**
 * @author SYAM K
 * @problem : Temp File for Practice before creating youtube video
 */

private var queue: LinkedList<Node> = LinkedList<Node>()

fun printExtremeNodes(head: Node?) {
    if(head == null) return
    queue.add(head)
    var flag = true
    var temp: Node
    while (queue.isNotEmpty()){
        val nodeCount = queue.size
        var n = nodeCount
        while (n-- > 0){
            temp = queue.peek()
            if(temp.left != null) queue.addLast(temp.left)
            if(temp.right != null) queue.addLast(temp.right)
            queue.remove()
            if(!flag && n == 0) println(temp.value)
            if(flag && n == nodeCount - 1) println(temp.value)
        }
        flag = !flag
    }
}
