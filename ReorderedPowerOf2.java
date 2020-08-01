class ReorderedPowerOf2 {
    public boolean reorderedPowerOf2(int N) {
        Map<Integer, Integer> original = getDigits(N);
        int powOf2 = 1;
        while (powOf2 < 1_000_000_000) {
            Map<Integer, Integer> current = getDigits(powOf2);
            if (original.equals(current)) return true;
            powOf2 <<= 1;
        }
        return false;
    }
    
    private Map<Integer, Integer> getDigits(int n) {
        Map<Integer, Integer> digits = new HashMap<>();
        while (n > 0) {
            int t = n % 10;
            digits.put(t, digits.getOrDefault(t, 0) + 1);
            n /= 10;
        }
        return digits;
    }
}