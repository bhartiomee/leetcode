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
    int ans=0;
    public int maxDepth(TreeNode root) {
        if(root==null)return ans;
        helper(root,0);
        return ans+1;
    }

    public void helper(TreeNode root,int len){
        if(root==null)return ;
        ans=Math.max(ans,len);
        if(root.left!=null)helper(root.left,len+1);
        if(root.right!=null) helper(root.right,len+1);
    }
}