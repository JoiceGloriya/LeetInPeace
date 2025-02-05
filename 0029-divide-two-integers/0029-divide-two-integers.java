class Solution {
    public int divide(int dividend, int divisor) {
        // Brute Force: dividend = 22, divisor = 3, O/P : 7 [3 + 3 + 3 + ... (7 times)] i.e linearly iterating over the divident with a given divisor, but this can be optimised, by the concept of bit manipulation, cuz evry number can be repd as "summation of powers of two" , makin' use of this fact...
        // Optimal:
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean isNegative = true;
        isNegative = (dividend < 0) ^ (divisor < 0);
        long n = Math.abs((long)dividend);
        // If dividend is Integer.MIN_VALUE (-2³¹), its absolute value (2³¹) cannot be represented as an int because the maximum value for int is Integer.MAX_VALUE (2³¹ - 1).
        long div = Math.abs((long)divisor);
        long sum = 0;
        int ct = 0;
        while(div <= n) {
            ct = 0;
            while((div << (ct + 1)) <= n) {
                ct++;
            }
            sum = sum + (1 << ct);
            n -= (div << ct);
        }
        
        return isNegative ? (int)(-sum) : (int)(sum);
    }
}