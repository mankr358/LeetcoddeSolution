public class Solution {
    private static final int MOD = 1000000007;

    // Corrected power function with proper recursion and modular handling
    public long power(long base, long n) {
        if (n == 0) return 1;
        long temp = power(base, n / 2);
        if (n % 2 == 0) {
            return (temp * temp) % MOD;
        } else {
            return (base * temp * temp) % MOD;
        }
    }

    public int countGoodNumbers(long n) {
        // Even-indexed positions should contain prime digits
        long evenPos = (n + 1) / 2;  // Number of even-indexed positions
        long oddPos = n / 2;         // Number of odd-indexed positions
        
       
        long evenPow = power(5, evenPos);  // 4 prime digit options for even-indexed positions
        long oddPow = power(4, oddPos);    // 5 even digit options for odd-indexed positions
        
        // Return the result, using modular arithmetic to avoid overflow
        return (int) ((evenPow * oddPow) % MOD);
    }
}
