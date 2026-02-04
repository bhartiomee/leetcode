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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)return ans;

        q.add(root);

        while(!q.isEmpty()){
            int size=q.size();
            List<Integer>tmp=new ArrayList<>();

            for(int i=0;i<size;i++){
                TreeNode top=q.poll();
                 tmp.add(top.val);
                if(top.left!=null)q.offer(top.left);
                if(top.right!=null)q.offer(top.right);
            }
            ans.add(tmp);
        }

        return ans;
    }
}