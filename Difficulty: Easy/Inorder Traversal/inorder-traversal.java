/* Structure of Binary Tree Node
class Node {
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
}*/

class Solution {
    public ArrayList<Integer> inOrder(Node root) {
         ArrayList<Integer> ans = new ArrayList<>();
         dfs(root,ans);
          return ans;
        
    }
    
    public void dfs(Node root, ArrayList<Integer> ans){
        if(root == null) return;
        dfs(root.left,ans);
        ans.add(root.data);
        dfs(root.right,ans);
    }
}