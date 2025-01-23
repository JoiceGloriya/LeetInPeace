class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(0, nums, list, new ArrayList<>());
        return list;
    }

    void backtrack(int startIndex, int[] nums, List<List<Integer>> list, List<Integer> tempList) {
        if (startIndex == nums.length) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        tempList.add(nums[startIndex]);
        backtrack(startIndex + 1, nums, list, tempList);
        tempList.remove(tempList.size() - 1);
        backtrack(startIndex + 1, nums, list, tempList);
    }
}