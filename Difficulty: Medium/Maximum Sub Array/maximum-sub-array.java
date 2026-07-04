import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> findSubarray(int[] arr) {

        ArrayList<Integer> ans = new ArrayList<>();

        long currSum = 0;
        long maxSum = -1;

        int start = 0;
        int end = -1;
        int tempStart = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] >= 0) {

                currSum += arr[i];

                if (currSum > maxSum ||
                   (currSum == maxSum && (i - tempStart > end - start))) {

                    maxSum = currSum;
                    start = tempStart;
                    end = i;
                }

            } else {

                currSum = 0;
                tempStart = i + 1;
            }
        }

        if (maxSum == -1) {
            ans.add(-1);
            return ans;
        }

        for (int i = start; i <= end; i++) {
            ans.add(arr[i]);
        }

        return ans;
    }
}