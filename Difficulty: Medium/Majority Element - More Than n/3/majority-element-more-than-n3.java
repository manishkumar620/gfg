class Solution {
    public ArrayList<Integer> findMajority(int[] arr) {
        int candidate1 = Integer.MIN_VALUE; 
        int count1 = 0;
        
        int candidate2 = Integer.MIN_VALUE;
        int count2 = 0;
        
        for(int num : arr){
            if(candidate1 == num){
                count1++;
            }
            else if(candidate2 == num){
                count2++;
            }
            
            else if(count1 == 0){
                candidate1 = num;
                count1 = 1;
            }
            
            else if(count2 == 0){
                candidate2 = num;
                count2 = 1;
            }
            
            else{
                count1--;
                count2--;
            }
            
        }
        
        count1 = 0;
        count2 = 0;
        
        for(int num : arr){
            if(num == candidate1){
                count1++;
            }
            
            if(num == candidate2){
                count2++;
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        if(count1>arr.length/3) {
            ans.add(candidate1);
        }
        
        if(candidate2 != candidate1 && count2>arr.length/3) {
            ans.add(candidate2);
        }
        
        Collections.sort(ans);
        
        return ans;
    }
}