class Solution {
    fun leftmostBuildingQueries(heights: IntArray, queries: Array<IntArray>): IntArray {
        val n = queries.size
        val hn = heights.size
        val res = IntArray(n)
        val stack = Stack<Int>() //monotonic stack
        val nge = IntArray(hn) { -1 }
        for (i in hn - 1 downTo 0) {
            val ce = heights[i]
            while (stack.isNotEmpty() && ce >= heights[stack.peek()]) {
                stack.pop()
            }
            if (stack.isNotEmpty()) nge[i] = stack.peek()
            stack.push(i)
        }
        for (i in queries.indices) {
            val I = queries[i][0]
            val J = queries[i][1]
            res[i] = if (I == J) I 
            else if ((I < J) && (heights[I] < heights[J])) J
            else if ((I > J) && (heights[I] > heights[J])) I
            else if (nge[J] == -1 || nge[I] == -1) -1
            else {
                var k = maxOf(I, J)
                val mx = maxOf(heights[I], heights[J])
                while (k < hn) {
                    if (heights[k] > mx) break
                    k = if (nge[k] == -1) k + 1 else nge[k]
                }
                if (k >= hn) -1 else k
            }
        }
        return res
    }
}