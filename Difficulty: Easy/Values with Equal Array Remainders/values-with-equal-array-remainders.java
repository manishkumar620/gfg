class Solution {
    public int sameMod(int[] arr) {
       
        int n = arr.length;

        int gcd = 0;

        // Find GCD of differences
        for (int i = 1; i < n; i++) {
            gcd = findGCD(gcd, Math.abs(arr[i] - arr[0]));
        }

        // All elements are equal
        if (gcd == 0) {
            return -1;
        }

        // Count divisors of GCD
        int count = 0;

        for (int i = 1; i * i <= gcd; i++) {
            if (gcd % i == 0) {
                count++;

                // i and gcd/i are two different divisors
                if (i != gcd / i) {
                    count++;
                }
            }
        }

        return count;
    }

    private int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}