class Solution {
    public void rotateMatrix(int[][] mat) {
      int n = mat.length;
      
      for(int i=0; i<n; i++) {
          for(int j=i+1; j<n; j++) {
              int temp = mat[i][j];
              mat[i][j] = mat[j][i];
              mat[j][i] = temp;
          }
      }
      
      
      for(int j = 0; j<n; j++){
          
          int left = 0;
          int right = n-1;
          
          while(left < right) {
          
          int temp = mat[left][j];
          mat[left][j] = mat[right][j];
          mat[right][j] = temp;
          
          left++;
          right--;
          }
      } 
        
    }
}