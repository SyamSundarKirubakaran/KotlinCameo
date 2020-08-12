package trees

import trees.util.Node
import trees.util.constructBalancedTree
import java.util.*

/**
 * @author SYAM K
 * @problem : Find the next right node of a given node in the same level
 */

fun main() {
    val head = constructBalancedTree()
    println(findNextRight(head, 3))
}

/**
 *           1
 *       /       \
 *      2         3
 *    /   \     /  \
 *   4     5   6    7
 *  / \   / \ / \  / \
 */

fun findNextRight(head: Node?, k: Int): Node? {
    if(head == null) return null
    val qn: Queue<Node> = LinkedList()
    val ql: Queue<Int> = LinkedList()

    qn.add(head)
    ql.add(0)

    while(qn.isNotEmpty()){
        val node = qn.remove()
        val level = ql.remove()
        if(node.value == k){
            return if(ql.isEmpty() || ql.peek() != level) null else qn.peek()
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