package trees

import trees.util.Node
import trees.util.constructBalancedTree

/**
 * @author SYAM K
 * @problem : Convert a BT into DLL
 */

fun main() {
    val head = constructBalancedTree()
    printDllValues(convertToDLL(head))
}

/**
 *           1
 *       /       \
 *      2         3
 *    /   \     /  \
 *   4     5   6    7
 *  / \   / \ / \  / \
 */

fun convertToDLL(head: Node?): Node? {
    if(head == null) return head
    if(head.left != null){
        var leftST = convertToDLL(head.left)
        while (leftST!!.right != null){
            leftST = leftST.right
        }
        leftST.right = head
        head.left = leftST
    }
    if(head.right != null){
        var rightST = convertToDLL(head.right)
        while (rightST!!.left != null){
            rightST = rightST.left
        }
        rightST.left = head
        head.right = rightST
    }
    return head
}

fun printDllValues(node: Node?) {
    var resultNode = node
    while (resultNode?.left != null) {
        resultNode = resultNode.left
    }
    while (resultNode != null) {
        print("${resultNode.value} ")
        resultNode = resultNode.right
    }
}
