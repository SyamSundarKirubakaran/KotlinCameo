package trees

import trees.util.Node
import trees.util.constructBalancedTree
import java.util.*

/**
 * @author SYAM K
 * @problem : Spiral Level Order Traversal
 */

private val s1: Stack<Node> = Stack<Node>()
private val s2: Stack<Node> = Stack<Node>()

fun main() {
    val head = constructBalancedTree()
    printSpiral(head)
}

/**
 *           1
 *       /       \
 *      2         3
 *    /   \     /  \
 *   4     5   6    7
 *  / \   / \ / \  / \
 */

fun printSpiral(head: Node?) {
    if (head != null) {
        s1.push(head)
        while (s1.isNotEmpty() || s2.isNotEmpty()){
            while (s1.isNotEmpty()){
                val (value, left, right) = s1.pop()
                println(value)
                if (right != null) {
                    s2.push(right)
                }
                if (left != null) {
                    s2.push(left)
                }
            }
            while (s2.isNotEmpty()){
                val (value, left, right) = s2.pop()
                println(value)
                if (left != null) {
                    s1.push(left)
                }
                if(right != null){
                    s1.push(right)
                }
            }
        }
    }
}