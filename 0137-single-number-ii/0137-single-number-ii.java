class Solution {
    public int singleNumber(int[] nums) {
        //Brute: HashMaps
        //Better Approach:  TC -> O(N*31) SC -> O(1)
        // int ans = 0;
        // for(int i = 0; i < 31; i ++) {
        //     int ct = 0;
        //     for(int j = 0; j < nums.length; j ++) {
        //         if((nums[j] & (1 << i)) != 0) 
        //             ct++;
        //     }
        //     if(ct % 3 != 0)
        //         ans = (ans | (1 << i));
        // }
        // return ans;
        //Betterrrr Approach:  TC -> O(N*logN + N / 3) SC -> O(1)
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i += 3)
            if(nums[i-1] != nums[i]) return nums[i-1];
        return nums[nums.length - 1];
    }
}