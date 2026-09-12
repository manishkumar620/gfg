class Solution {
    long maxProduct(int arr[], int k) {
        int n = arr.length;
        long NEG_INF = Long.MIN_VALUE / 2;
        long POS_INF = Long.MAX_VALUE / 2;

        long[] dpMax = new long[k + 1];
        long[] dpMin = new long[k + 1];

        Arrays.fill(dpMax, NEG_INF);
        Arrays.fill(dpMin, POS_INF);
        dpMax[0] = 1;
        dpMin[0] = 1;

        for (int i = 0; i < n; i++) {
            int a = arr[i];
            long[] newMax = dpMax.clone();
            long[] newMin = dpMin.clone();

            for (int j = k; j >= 1; j--) {
                if (dpMax[j - 1] != NEG_INF) {
                    long prod1 = dpMax[j - 1] * a;
                    long prod2 = dpMin[j - 1] * a;

                    newMax[j] = Math.max(newMax[j], Math.max(prod1, prod2));
                    newMin[j] = Math.min(newMin[j], Math.min(prod1, prod2));
                }
            }

            dpMax = newMax;
            dpMin = newMin;
        }

        return dpMax[k];
    }
}