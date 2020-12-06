class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        generateSubsets(0, nums, new ArrayList<Integer>(), subsets);
        List<String> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (List<Integer> l : subsets) {
            String s = l.toString();
            if (temp.contains(s)) continue;
            else {
                temp.add(s);
                ans.add(l);
            }
        }
        return ans;
    }
    
    private void generateSubsets(int idx, int[] nums, ArrayList<Integer> current, 
			List<List<Integer>> subsets) {
		// TODO Auto-generated method stub
		subsets.add(new ArrayList<Integer>(current));
		for (int i = idx; i < nums.length; i++) {
			current.add(nums[i]);
			generateSubsets(i + 1, nums, current, subsets);
			current.remove(current.size() - 1);
		}
	}
}