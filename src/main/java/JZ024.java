import java.util.ArrayList;

/**
 * @program: JZOffer
 * @description: 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * @author: JJGGu
 * @create: 2020-09-25 16:02
 **/
public class JZ024 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return result;
        }
        find(root, target);
        return result;
    }

    private void find(TreeNode root, int target) {
        temp.add(root.val);
        if (target == root.val && root.left == null && root.right == null) {
            result.add(new ArrayList<>(temp));
        }

        if (root.left != null) {
            find(root.left, target -root.val);
        }
        if (root.right != null) {
            find(root.right, target - root.val);
        }
        temp.remove((Integer)root.val);

    }
}
