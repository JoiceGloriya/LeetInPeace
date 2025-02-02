class Solution {
    public int hammingDistance(int x, int y) {
        int ans = x ^ y;
        //count the number of bits that are set
        int ct = 0;
        while(ans != 0) {
            ans = (ans & (ans - 1));
            ct++;
        }
        return ct;
    }
}