class ElementAppearingMoreThan25PercentileInSortedArray {
    public int findSpecialInteger(int[] arr) {
        int res = (int) Math.ceil(arr.length / 4);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if (map.get(i) > res) return i;
        }
        return 0;
    }
}

//FORMULA
// 25% means 1/4th 