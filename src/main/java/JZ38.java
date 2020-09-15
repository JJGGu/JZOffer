import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: JZOffer
 * @description: 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * @author: JJGGu
 * @create: 2020-09-15 11:28
 **/
public class JZ38 {
    // 1.递归法
    public int TreeDepth(MyBinaryTree.TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth((root.right));
        return left > right ? ++left : ++right;
    }

    // 2.层序遍历法
    public int TreeDepth2(MyBinaryTree.TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<MyBinaryTree.TreeNode> queue = new LinkedList<>();
        queue.add(root);
        MyBinaryTree.TreeNode last = root;
        int count = 0;
        while (!queue.isEmpty()) {
            MyBinaryTree.TreeNode cur = queue.poll();
            if (last == cur) {
                count++;
            }
            if (cur.left != null) {
                queue.add(cur.left);
                if (last == cur) {
                    last = cur.left;
                }
            }
            if (cur.right != null) {
                queue.add(cur.right);
                if (last == cur) {
                    last = cur.right;
                }
            }
            if (cur == last && last.right == null && last.left == null && !queue.isEmpty()) {
                count++;
            }
        }
        return count;
    }
}
