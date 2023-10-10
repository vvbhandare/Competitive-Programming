class Solution {
    private lateinit var primes: BooleanArray
    fun findPrimePairs(n: Int): List<List<Int>> {
        //prepare sieve of eratosthenes
        SOE(n + 1)

        // iterate through primes array & check if number, n - number both are primes
        // if yes then add that pair in o/p list
        val ans = mutableListOf<MutableList<Int>>()
        var i = 2
        while (i <= n / 2) {
            val list = mutableListOf<Int>()
            if (primes[i] && primes[n - i]) {
                list.add(i)
                list.add(n - i)
                ans.add(list)
            }
            i++
        }

        return ans
    }

    private fun SOE(n: Int) {
        // Iniitally fill entire array with true by assuming it as primes
        primes = BooleanArray(n + 1)
        primes.fill(true)

        // mark 0, 1 as non-primes/false
        primes[0] = false
        primes[1] = false

        // standard algo to mark elements which are multiple of that number to non-prime
        var i = 2
        while (i * i <= n) {
            if (primes[i]) {
                var j = i * i
                while (j <= n) {
                    primes[j] = false
                    j += i
                }
            }
            i++
        }
    }
}