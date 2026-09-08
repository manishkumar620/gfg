// class Solution {
//     public ArrayList<ArrayList<Integer>> searchWord(char[][] mat, String word) {
//     int n = word.length; 
//     int m = word[0].length;
     
//         int dx[] = {-1,-1,-1,0,0,1,1,1};
//         int dy[] = {-1,0,1,1,-1,1,0,-1};
//         for(int i=0; i<n; i++){
//             for(int j =0; j<m; j++){
//                 if(mat[i][j] != word[0]){
//                     continue;
//                 }
//             }
//         }
        
//         while(left < right){
//             if(x>0 && x<n && y>=0 && y<m && wordCharAt(idx) == grid[n])
//         }
        
        
    
            
//         }
        
//     }
// };
class Solution {
    public ArrayList<ArrayList<Integer>> searchWord(char[][] mat, String word) {

        int n = mat.length;
        int m = mat[0].length;

        int[] dx = {-1,-1,-1,0,0,1,1,1};
        int[] dy = {-1,0,1,-1,1,-1,0,1};

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (mat[i][j] != word.charAt(0))
                    continue;

                for (int d = 0; d < 8; d++) {

                    int x = i;
                    int y = j;
                    int k = 0;

                    while (k < word.length()) {

                        if (x < 0 || x >= n || y < 0 || y >= m)
                            break;

                        if (mat[x][y] != word.charAt(k))
                            break;

                        x += dx[d];
                        y += dy[d];
                        k++;
                    }

                    if (k == word.length()) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(i);
                        temp.add(j);
                        ans.add(temp);
                        break;
                    }
                }
            }
        }

        return ans;
    }
}