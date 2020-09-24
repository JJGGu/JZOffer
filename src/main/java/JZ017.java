/**
 * @program: JZOffer
 * @description: 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * @author: JJGGu
 * @create: 2020-09-23 21:03
 **/
public class JZ017 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }

        return subtree(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);

    }
    private boolean subtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null || root1.val != root2.val) {
            return true;
        }

        return subtree(root1.left, root2.left) && subtree(root1.right, root2.right);
    }
}
