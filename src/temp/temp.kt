package temp

import trees.util.Node
import java.util.*

/**
 * @author SYAM K
 * @problem : Temp File for Practice before creating youtube video
 */


fun convertTree(node: Node?) {
    var leftData = 0
    var rightData = 0
    val diff: Int
    if(node?.left != null || node?.right != null){
        trees.convertTree(node.left)
        trees.convertTree(node.right)
        if (node.left != null) leftData = node.left!!.value
        if (node.right != null) rightData = node.right!!.value
        diff = leftData + rightData - node.value
        if (diff > 0) {
            node.value = node.value + diff
        } else {
            increment(node, -diff)
        }
    }
}

fun increment(node: Node?, diff: Int) {
    if (node != null) {
        if (node.left != null) {
            node.left!!.value = node.left!!.value + diff
            increment(node.left, diff)
        } else if (node.right != null) {
            node.right!!.value = node.right!!.value + diff
            increment(node.right, diff)
        }
    }
}
