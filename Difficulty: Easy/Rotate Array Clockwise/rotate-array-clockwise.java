class Solution {
    public void rotateclockwise(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        
        reverse(arr,0,n-1);
        reverse(arr,0,k-1);
        reverse(arr,k,n-1);
        
    }
    private void reverse(int[] arr, int left, int right) {
        while ( left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}