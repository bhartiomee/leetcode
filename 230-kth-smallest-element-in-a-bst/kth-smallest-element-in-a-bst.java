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
    PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

    public int kthSmallest(TreeNode root, int k) {

        traverse(root,k);
        return pq.poll();
    }

    public void traverse(TreeNode root,int k){
        if(root==null)return;
        pq.offer(root.val);

        while(pq.size()>k){
            pq.poll();
        }
        traverse(root.left,k);
        traverse(root.right,k);
    }
}