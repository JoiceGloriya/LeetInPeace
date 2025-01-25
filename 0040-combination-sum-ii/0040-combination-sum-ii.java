class Solution {
    // TC -> O(2^N * NlogN * k) where k is avg len of each combination
    // SC -> O(k*x) where x is number of such combinations
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, target, candidates, new ArrayList(), list);
        return list;
    }

    void backtrack(int startIndex, int target, int[] nums, List<Integer> a, List<List<Integer>> list) {
        if (target == 0) {
            list.add(new ArrayList<>(a));// contributes O(k) in TC
            return;
        }
        if(startIndex == nums.length) return;
        for (int i = startIndex; i < nums.length; i++) {
            if (nums[i] > target)
                break;
            if (i > startIndex && nums[i] == nums[i - 1])
                continue;
            a.add(nums[i]);
            backtrack(i + 1, target - nums[i], nums, a, list);
            a.remove(a.size() - 1);
        }
    }
}