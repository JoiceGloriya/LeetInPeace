class Solution {
    public int minBitFlips(int start, int goal) {
        int ans = (start ^ goal);
        int bitFlips = 0;
        while(ans != 0) {
           ans = (ans & (ans - 1));
           bitFlips++; 
        }
        return bitFlips;
    }
}