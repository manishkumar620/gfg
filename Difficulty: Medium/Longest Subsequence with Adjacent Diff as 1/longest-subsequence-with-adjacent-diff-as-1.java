class Solution {
    public int longestSubseq(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int answer = 0;
        for(int i=0; i<arr.length; i++){
             int x = arr[i];
              int  currentlength = map.getOrDefault(x-1,0)+1;
              map.put(x, Math.max(map.getOrDefault(x+1,0)+1,currentlength));
              answer = Math.max(answer, map.get(x));
            } 
        return answer;
    }
}

