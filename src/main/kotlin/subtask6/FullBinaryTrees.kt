package subtask6

import java.lang.Integer.max
import kotlin.collections.ArrayList

class FullBinaryTrees {
    private fun growForest(amt: Int): ArrayList<Node>{
        if(amt == 1) return arrayListOf(Node())
        val result = ArrayList<Node>()
        for (i in 1 until amt step 2) {
            growForest(i).forEach { daughter ->
                growForest(amt - i - 1).mapTo(result) { Node(max(daughter.level, it.level)+1, daughter, it) }
            }
        }
        return result
    }

    private fun deepPrint(node: Node):ArrayList<Int?>{
        var depthLevel = 0
        val result = arrayListOf<Int?>(0)
        val children = arrayListOf(node.left, node.right)
        val grandchildren = ArrayList<Node?>()
        while(children.isNotEmpty()){
            children.forEach {
                when {
                    it == null && depthLevel != node.level -> result.add(null)
                    it != null -> {
                        result.add(0)
                        grandchildren.addAll(arrayListOf(it.left, it.right))
                    }
                }
            }
            depthLevel++
            children.clear()
            children.addAll(grandchildren)
            grandchildren.clear()
        }
        return result
    }


    fun stringForNodeCount(count: Int): String {
        if(count % 2 == 0) return "[]"
        if(count == 1) return "[[0]]"
        val sb = StringBuilder()
        for(node in growForest(count)){
            val list = deepPrint(node)
            while (list[list.size - 1] == null) list.removeAt(list.size - 1)
            sb.append(list.toString())
            sb.append(",")
        }
        return "[${sb.removeRange(sb.length-4, sb.length-3)}]"
    }

}

class Node(var level: Int = 0, var left: Node? = null, var right: Node? = null)
