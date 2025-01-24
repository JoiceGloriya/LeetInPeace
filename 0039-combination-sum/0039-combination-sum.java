class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(0, candidates, target, new ArrayList<>(), list);
        return list;
    }

    void backtrack(int startIndex, int[] nums, int target, List<Integer> a, List<List<Integer>> list) {
        if(target == 0) { //ArrayLists are mutable, so after adding whatvr changes you' re doing, will be reflected in list also! so always create a  cpy of 'a' list into another 1D list and add it to list like below:-
            // List<Integer> arr = new ArrayList<>(a);
            // list.add(arr);

            list.add(new ArrayList<>(a));
            return;
        }
        if(startIndex == nums.length) {
            return;
        }
        if(nums[startIndex] <= target) {
            a.add(nums[startIndex]);
            backtrack(startIndex, nums, target - nums[startIndex], a, list);
            a.remove(a.size() - 1);
        }
        backtrack(startIndex + 1, nums, target, a, list);
    }
}