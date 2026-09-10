class Solution {
    public int pairCount(int x, int y) {
        // LCM must be divisible by GCD, otherwise no valid pairs
        if (y % x != 0) {
            return 0;
        }

        int n = y / x;

        // Count distinct prime factors of n
        int k = 0;
        int temp = n;
        for (int d = 2; (long) d * d <= temp; d++) {
            if (temp % d == 0) {
                k++;
                while (temp % d == 0) {
                    temp /= d;
                }
            }
        }
        if (temp > 1) {
            k++;
        }

        // Each distinct prime factor of n can go entirely to a/x or b/x
        return 1 << k; // 2^k
    }
}