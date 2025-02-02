class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // backtrack(0, nums, list, new ArrayList<>());
        for(int i = 0; i < (1 << nums.length); i ++) {
            List<Integer> tempList = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) 
                tempList.add(nums[j]);
            }
            list.add(new ArrayList<>(tempList));
        }
        return list;
    }

    // TC -> O(2^N) [for each number in the array you have two choices, whether to include it or not]
    // SC -> O(N)

    // void backtrack(int startIndex, int[] nums, List<List<Integer>> list, List<Integer> tempList) {
    //     if (startIndex == nums.length) {
    //         list.add(new ArrayList<>(tempList));
    //         return;
    //     }
    //     tempList.add(nums[startIndex]);
    //     backtrack(startIndex + 1, nums, list, tempList);
    //     tempList.remove(tempList.size() - 1);
    //     backtrack(startIndex + 1, nums, list, tempList);
    // }
}