package temp

import trees.util.Node

/**
 * @author SYAM K
 * @problem : Temp File for Practice before creating youtube video
 */

fun subTree(head: Node?, smallerHead: Node?): Boolean {
    if (smallerHead == null) return true
    if (head == null) return false
    return if (identical(head, smallerHead)) true
    else subTree(head.left, smallerHead) || subTree(head.right, smallerHead)
}

fun identical(head: Node?, smallerHead: Node?): Boolean {
    if (head == null && smallerHead == null) return true
    return if (head == null || smallerHead == null) false
    else head.value == smallerHead.value && identical(
        head.left,
        smallerHead.left
    ) && identical(
        head.right,
        smallerHead.right
    )
}