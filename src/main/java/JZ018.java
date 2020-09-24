/**
 * @program: JZOffer
 * @description: 操作给定的二叉树，将其变换为源二叉树的镜像。
 * @author: JJGGu
 * @create: 2020-09-23 22:15
 **/
public class JZ018 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public void Mirror(TreeNode root) {
        mirror(root);
    }

    private TreeNode mirror(TreeNode root) {
        if (root != null) {
            TreeNode left = mirror(root.left);
            TreeNode right = mirror(root.right);
            TreeNode temp = left;
            root.left = right;
            root.right = temp;
            return root;
        } else {
            return null;
        }
    }
}
