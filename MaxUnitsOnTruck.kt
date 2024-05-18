class Solution {
    fun maximumUnits(boxTypes: Array<IntArray>, truckSize: Int): Int {
        val sa = boxTypes.sortedByDescending { it[1] }
        var sum = 0
        var total = 0
        sa.forEach {
            var f = it[0]
            var s = it[1]
            if (truckSize - sum - f < 0) {
                var a = truckSize - sum
                sum += a
                total += (a * s)
            } else if (sum + f <= truckSize) {
                sum += f
                total += (f * s)
            }  
        }
        return total
    }
}