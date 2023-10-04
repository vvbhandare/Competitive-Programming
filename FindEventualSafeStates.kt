class Solution {

    // solve by topological sort | kahn's algo
    fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
        val n = graph.size
        val queue = LinkedList<Int>()
        val adj = MutableList(n) { mutableListOf<Int>() }
        val indeg = IntArray(n)
        val res = mutableListOf<Int>()

        // prepare adjecancy list
        for (i in 0 until n) {
            for (j in graph[i]) {
                adj[j].add(i)
            }
        }

        // println(adj)

        // calculate indegree of each vertex
        for (i in 0 until n) {
            for (j in adj[i]) {
                indeg[j]++
            }
        }

        // println(indeg.toList())

        // add vertex with indegree=0 in queue
        for (i in 0 until n) {
            if (indeg[i] == 0) queue.add(i)
        }

        // println(queue)

        // iterate through queue
        while (!queue.isEmpty()) {
            val u = queue.poll()
            // println(queue)
            // println(u)
            for (v in adj[u]) {
                // println("$u -> $v")
                indeg[v]--
                // println(indeg.toList())
                if (indeg[v] == 0) queue.add(v)
            }
        }
        
        // println(indeg.toList())

        for (i in 0 until n) {
            if (indeg[i] == 0) res.add(i)
        }

        return res

    }
}