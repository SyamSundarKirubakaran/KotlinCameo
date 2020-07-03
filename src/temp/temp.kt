package temp

import trees.util.Node

/**
 * @author SYAM K
 * @problem : Temp File for Practice before creating youtube video
 */

private var min: Int = Int.MAX_VALUE
private  var max:Int = Int.Companion.MIN_VALUE
private val hash: LinkedHashMap<Int, Node> = LinkedHashMap()

fun findTopView(head: Node) {
    getMinMax(head, 0)
    for (lineNo in min..max) {
        inflateTopView(head, lineNo, 0)
    }
    hash.forEach { (_, u) ->
        println(u.value)
    }
}

fun inflateTopView(head: Node?, lineNo: Int, hd: Int) {
    if (head == null) return
    if (hd == lineNo) hash.putIfAbsent(lineNo, head)
    inflateTopView(head.left, lineNo, hd - 1)
    inflateTopView(head.right, lineNo, hd + 1)
}

fun getMinMax(head: Node?, index: Int) {
    if (head == null) return
    if (index < min) min = index
    if (index > max) max = index
    getMinMax(head.left, index - 1)
    getMinMax(head.right, index + 1)
}