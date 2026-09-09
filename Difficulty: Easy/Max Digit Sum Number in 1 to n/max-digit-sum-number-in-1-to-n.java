class Solution {

    public int findMax(int n) {
        int maxsum = getDigitSum(n);
        int ans = n;
        int x =n ,d = 1;
        while(x>0){
             int newNumber = (x-1)*d+(d-1);
             int digitsum = getDigitSum(newNumber);
            if(digitsum > maxsum){
                maxsum = digitsum;
                ans = newNumber;
            }
                 x = x / 10;
                 d = d * 10;
            }
            
            return ans;
        }
        
        private int getDigitSum(int n){
            int digitSum = 0;
            while(n>0){
                digitSum +=(n%10);
                n = n/10;
        }
         return digitSum;
    }
            
}
    
       