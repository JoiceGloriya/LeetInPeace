class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // TC -> O((2^N) *(NlogN) * (N))
        // SC -> O((2^N) * (k) * (N))
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0, nums, new ArrayList<>(), list);
        return list;
    }

    void backtrack(int startIndex, int[] nums, List<Integer> a, List<List<Integer>> list) {
        list.add(new ArrayList<>(a));
        if (startIndex == nums.length)
            return;
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1])
                continue;
            a.add(nums[i]);
            backtrack(i + 1, nums, a, list);
            a.remove(a.size() - 1);
        }
    }
}