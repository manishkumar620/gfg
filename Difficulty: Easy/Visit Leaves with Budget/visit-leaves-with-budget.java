/* Binary Tree Node Structure
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    public int getCount(Node root, int k) {
        if (root == null) return 0;

        List<Integer> leafLevels = new ArrayList<>();
        collectLeafLevels(root, 1, leafLevels);

        // Greedy: sort leaf costs ascending, pick cheapest leaves first
        Collections.sort(leafLevels);

        int count = 0;
        int totalCost = 0;

        for (int cost : leafLevels) {
            if (totalCost + cost <= k) {
                totalCost += cost;
                count++;
            } else {
                break;
            }
        }

        return count;
    }

    private void collectLeafLevels(Node node, int level, List<Integer> leafLevels) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            leafLevels.add(level);
            return;
        }

        collectLeafLevels(node.left, level + 1, leafLevels);
        collectLeafLevels(node.right, level + 1, leafLevels);
    }
}