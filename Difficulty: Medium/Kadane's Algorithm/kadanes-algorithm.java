class Solution {
    int maxSubarraySum(int[] arr) {
        int sum = 0; 
        int maxi = arr[0];
        
        for(int i = 0; i<arr.length; i++) {
            sum += arr[i];
            
        maxi = Math.max(maxi,sum);
        
        if(sum < 0) {
            sum = 0;
        }
        }
        
        return maxi;
    }
}
