// Time complexity - O(n) - n is the number of nodes
// Space complexity - O(breadth) - breadth - the maximum number of children on a particular level
// Works on leetcode

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        // Add the root
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                // Pop all the nodes at a given level
                TreeNode front = queue.poll();
                // Add the last node popped on a level to a list
                if(i==size-1){
                    result.add(front.val);
                }
                // Add the child nodes of the popped elemenets if they are not null
                if(front.left!=null){
                    queue.add(front.left);
                }
                if(front.right!=null){
                    queue.add(front.right);
                }
            }
        }
        return result;
        
    }
}
