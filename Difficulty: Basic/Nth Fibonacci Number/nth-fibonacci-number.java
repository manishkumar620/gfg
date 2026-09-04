class Solution {
    static int[] dp;
    public int Fibo(int n) {
        if (n <= 1) return n; 
         if(dp[n] != 0) return dp[n];
            int ans =  Fibo(n-1) + Fibo(n-2);
            dp[n] = ans;
             return ans;
        }
        
        
        
        public int nthFibonacci(int n){
            dp = new int[n+1];
            return Fibo(n);
            
        }
    }