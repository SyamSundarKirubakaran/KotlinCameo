package temp

import trees.postOrderIndex
import trees.searchInInOrder
import trees.util.Node

/**
 * @author SYAM K
 * @problem : Temp File for Practice before creating youtube video
 */

//fun construct(
//    inStart: Int,
//    inEnd: Int
//): Node? {
//    if (inStart > inEnd) return null
//    val node = Node(postOrder[postOrderIndex])
//    postOrderIndex -= 1
//    if (inStart == inEnd) return node
//    val inIndex: Int = searchInInOrder(inOrder, inStart, inEnd, node.value)
//    node.right = trees.construct(inIndex + 1, inEnd)
//    node.left = trees.construct(inStart, inIndex - 1)
//    return node
//}