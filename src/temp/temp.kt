package temp

import trees.util.Node

/**
 * @author SYAM K
 * @problem : Temp File for Practice before creating youtube video
 */

// Similar to all nodes at a distance K from the root
fun printKDistanceDown(node: Node?, k: Int) {
    if (node == null || k < 0) {
        return
    }
    if (k == 0) {
        print(node.value)
        return
    }
    trees.printKDistanceDown(node.left, k - 1)
    trees.printKDistanceDown(node.right, k - 1)
}

fun printFromAnyNode(node: Node?, target: Node, k: Int): Int {
    if (node == null) return -1
    if (node.value == target.value) {
        trees.printKDistanceDown(node, k)
        return 0
    }
    val dl = printFromAnyNode(node.left, target, k)
    if (dl != -1) {
        if (dl + 1 == k) print(node.value) else trees.printKDistanceDown(node.right, k - dl - 2)
        return dl + 1
    }
    val dr = printFromAnyNode(node.right, target, k)
    if (dr != -1) {
        if (dr + 1 == k) print(node.value) else trees.printKDistanceDown(node.left, k - dr - 2)
        return dr + 1
    }
    return -1
}

