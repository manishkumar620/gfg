/* Definition for Node
class Node
{
    int data;
    Node left;
    Node right;
    Node(int val)
    {
        this.data = val;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public ArrayList<ArrayList<Integer>> paths(Node root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        dfs(root,arr,ans);
        return ans;
        
    }
    private static void dfs(Node root, ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> ans){
    if(root == null) return;
    if(root.left == null && root.right == null){
        arr.add(root.data);
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(arr);
        ans.add(list);
        arr.remove(arr.size()-1);
        return;
    }
    arr.add(root.data);
    dfs(root.left,arr,ans);
    dfs(root.right,arr,ans);
    arr.remove(arr.size()-1);
}
}









