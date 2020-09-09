/**
 * @program: JZOffer
 * @description: 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * @author: JJGGu
 * @create: 2020-09-09 15:52
 **/
public class JZ17 {
    public static void main(String[] args) {

    }
    public static boolean HasSubtree(MyBinaryTree.TreeNode root1, MyBinaryTree.TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return recur(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }
    private static boolean recur(MyBinaryTree.TreeNode root1, MyBinaryTree.TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null || root1.val != root2.val) {
            return false;
        }

        return recur(root1.left, root2.left) && recur(root1.right, root2.right);
    }
}
