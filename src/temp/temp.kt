package temp

import trees.util.Node
import trees.util.SNode

/**
 * @author SYAM K
 * @problem : Temp File for Practice before creating youtube video
 */


fun evaluateExpression(head: SNode?): String? {
    if (head == null) return "!"
    if (head.value != "*" && head.value != "+" && head.value != "!") return head.value
    val left = trees.evaluateExpression(head.left)
    val right = trees.evaluateExpression(head.right)
    when (head.value) {
        "+" -> head.value = (left!!.toInt() + right!!.toInt()).toString() + ""
        "*" -> head.value = (left!!.toInt() * right!!.toInt()).toString() + ""
    }
    return head.value
}
