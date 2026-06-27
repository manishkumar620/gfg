class Solution {
    public int findKRotation(int arr[]) {
        if(arr.length <= 1 || arr[0] < arr[arr.length-1]) {
            return 0;
        }
        for(int i =1 ; i<arr.length; i++) {
           if(arr[i] < arr[i-1]) {
               return i;
           }
        }
        return 0;
    }
}