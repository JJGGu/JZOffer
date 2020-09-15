/**
 * @program: JZOffer
 * @description: 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 * @author: JJGGu
 * @create: 2020-09-15 13:30
 **/
public class JZ39 {
    public boolean IsBalanced_Solution(MyBinaryTree.TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = IsBalanced_Solution(root.left);
        boolean right = IsBalanced_Solution(root.right);
        if (Math.abs(height(root.left) - height(root.right)) > 1) {
            return false;
        } else {
            return left && right;
        }
    }
    public int height(MyBinaryTree.TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return left > right ? ++left: ++right;
    }
}
