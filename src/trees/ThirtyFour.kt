package trees

import trees.util.NNode
import trees.util.constructNaryTree
import java.util.*

/**
 * @author SYAM K
 * @problem : Serialization and Deserialization of a n-ary tree
 */

private var serialResult: LinkedList<NNode> = LinkedList()

fun main() {
    val head = constructNaryTree()
    serializeNary(head)
    println(serialResult.map { it.value })
    val resultHead = deserializeNary(serialResult)
    preOrderTraversal(resultHead)
}

/**
 *             0
 *        /     \    \
 *       1       2    3
 *    /  |  \     \    \
 *   4   5   6
 *   \    \   \
 */

fun serializeNary(head: NNode?) {
    if(head == null) serialResult.addLast(NNode(value = -1)) else {
        serialResult.addLast(head)
        head.children.forEach {
            serializeNary(it)
            serializeNary(null)
        }
    }
}

fun deserializeNary(serialResult: LinkedList<NNode>): NNode? {
    var head: NNode? = null
    if(serialResult.size > 0){
        val popped = serialResult.removeFirst()
        head = if(popped.value != -1) popped else null
        deserializeNary(serialResult)
    }
    return head
}

fun preOrderTraversal(head: NNode?) {
    head?.let {
        print("${head.value} ")
        it.children.forEach { preOrderTraversal(it) }
    }
}