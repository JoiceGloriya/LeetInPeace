class Solution {
    public int countGoodNumbers(long n) {
    long MOD = 1000000007;
    long odd = n / 2;
    long even = (n / 2) + (n % 2);
    return (int) ((modularExponentiation(5, even, MOD) * modularExponentiation(4, odd, MOD)) % MOD);
}

private long modularExponentiation(long base, long exp, long mod) {
    if (exp == 0) return 1;
    long half = modularExponentiation(base, exp / 2, mod);
    long result = (half * half) % mod;
    if (exp % 2 != 0) {
        result = (result * base) % mod;
    }
    return result;
}

}