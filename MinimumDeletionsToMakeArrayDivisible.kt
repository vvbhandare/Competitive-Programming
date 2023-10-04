class Solution {
    fun minOperations(nums: IntArray, numsDivide: IntArray): Int {
        var gcd = numsDivide[0]
        val n = numsDivide.size
        for (i in 1 until n) {
            gcd = GCD(gcd, numsDivide[i])
        }
        val arr = nums.sorted()
        // println(gcd)
        // println(arr.toList())
        for (i in 0 until arr.size) {
            // println(i)
            if (arr[i] <= gcd && gcd % arr[i] == 0) return i
        }
        return -1
    }

    // Std GCD formula
    private fun GCD(a: Int, b: Int): Int {
        if (b == 0) return a
        return GCD(b, a % b)
    }
}