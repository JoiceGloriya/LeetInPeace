class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int i = 0; i < nums.length; i ++)
            xor = (xor ^ nums[i]);
        long rightmost = ((xor & (xor - 1)) ^ xor); //must be long, bcoz if xor is the smallest integer, then xor - 1 will overflow the capacity of integer! 
        int bucket_1 = 0, bucket_2 = 0;
        for(int i = 0; i < nums.length; i ++) {
            if((rightmost & nums[i]) != 0) //some non-zero number
                bucket_1 ^= nums[i];
            else bucket_2 ^= nums[i];
        }
        return new int[] {bucket_1, bucket_2};
    }
}