class Solution {
    fun minimumPerimeter(neededApples: Long): Long {
        var total = 0L
        var i = 0L
        while (total < neededApples) {
            total += (i * 8)
            total += (i * 4)
            val ci = i * (i - 1)
            val ap = (i * (i - 1)) / 2
            val t = (ci + ap) * 8
            total += t
            i++
        }
        return (i - 1) * 8L
    }
}