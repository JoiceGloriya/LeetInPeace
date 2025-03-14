class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        int s3 = Integer.MIN_VALUE;
        for(int i = nums.length - 1; i >= 0; i --) {
            if(nums[i] < s3) return true;
            while(!stk.isEmpty() && nums[stk.peek()] < nums[i]) {
                s3 = nums[stk.pop()];
            }
            stk.push(i);
        }
        return false;
    }
}