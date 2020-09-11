
import java.util.ArrayList;

/**
 * @program: JZOffer
 * @description: 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * @author: JJGGu
 * @create: 2020-09-10 18:06
 **/
public class JZ24 {
    ArrayList<Integer> trace = new ArrayList<Integer>();
    ArrayList<ArrayList<Integer>> allTrace = new ArrayList<ArrayList<Integer>>();

    private void recur(MyBinaryTree.TreeNode root, int target) {
        if (target == root.val && root.left == null && root.right == null) {
            // 重新new 一个list对象
            allTrace.add(new ArrayList<Integer>(trace));
        }

        trace.add(root.val);
        if (root.left != null) {
            recur(root.left, target - root.val);
        }
        if (root.right != null) {
            recur(root.right, target - root.val);
        }
        // 说明该条路径不符，移出该节点
        trace.remove((Integer)root.val);
    }
    public ArrayList<ArrayList<Integer>> FindPath(MyBinaryTree.TreeNode root, int target) {
        if (root == null) {
            return allTrace;
        }
        recur(root, target);
        return allTrace;
    }
}
