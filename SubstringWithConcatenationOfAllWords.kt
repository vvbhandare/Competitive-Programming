class Solution {
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        val sl = s.length
        val wl = words.size
        val ewl = words[0].length

        val map = HashMap<String, Int>()
        words.forEach {
            map.put(it, map.getOrDefault(it, 0) + 1)
        }

        val ans = mutableListOf<Int>()

        for (i in 0 .. (sl - (wl * ewl))) {
            val cmap = HashMap<String, Int>(map)
            for (j in 0 until wl) {
                val s = s.substring(i + (j * ewl), i + (j * ewl) + ewl)
                if (cmap.containsKey(s)) {
                    if (cmap.get(s)!! > 1) cmap.put(s, cmap.get(s)!! - 1)
                    else cmap.remove(s)
                    if (cmap.isEmpty()) {
                        ans.add(i)
                        break
                    }
                } else break
            }
        }

        return ans
    }
}