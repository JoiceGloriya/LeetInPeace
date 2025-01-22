class Solution {
    public int countGoodNumbers(long n) {
    // evens  = 0, 2, 4, 6, 8  => 5 evens
    // primes = 2, 3, 5, 7     => 4 primes
    long MOD = 1000000007;
    long odd = n / 2;
    long even = (n / 2) + (n % 2);
    return (int) ((modularExponentiation(5, even, MOD) * modularExponentiation(4, odd, MOD)) % MOD);
}

private long modularExponentiation(long base, long exp, long mod) {
    // if (exp == 0) return 1;
    // long half = modularExponentiation(base, exp / 2, mod);
    // long result = (half * half) % mod;
    // if (exp % 2 != 0) {
    //     result = (result * base) % mod;
    // 
    // base = base % 1000000007;
    // if(base == 0) return 0;
    long result = 1;
    while(exp > 0) {
        if(exp % 2 == 1) result = (result * base) % 1000000007; 
        base = (base * base) % 1000000007;
        exp = exp / 2;
    }

    return result;
}

}