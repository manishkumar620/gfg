class Solution {
    public int findUnique(int[] arr) {
        int sum = 0;
        for(int i = 0; i<arr.length; i++) {
            sum = sum ^ arr[i];
        }
        return sum;
    }
}