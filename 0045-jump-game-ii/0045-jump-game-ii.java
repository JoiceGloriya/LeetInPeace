class Solution {
    public int jump(int[] nums) {
        // Optimal -> Greedy TC -> O(N) and SC -> O(1)
        int l = 0, r = 0, jumps = 0;
        while(r < nums.length - 1) {
            int farthestDistance = 0;
            for(int ind = l; ind <= r; ind ++) {
                farthestDistance = Math.max(farthestDistance, ind + nums[ind]);
            }
            l = r + 1;
            r = farthestDistance;
            jumps++;
        }
        return jumps;
    }
}

// class Solution { BF -> TC -> O(N^N)  SC -> O(N) [RECURSIVE STK SPACE]
//     public int jump(int[] nums) {
//         return backtrack(0, 0, nums);
//     }

//     int backtrack(int start, int jumps, int[] nums) {
//         if(start >= nums.length - 1) return jumps;
//         int mini = Integer.MAX_VALUE;
//         for(int i = 1; i <= nums[start]; i ++) 
//             mini = Math.min(mini, backtrack(start + i, jumps + 1, nums));

//         return mini;
//     }
// }