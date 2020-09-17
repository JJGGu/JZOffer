import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: JZOffer
 * @description: 给定一棵二叉搜索树，请找出其中的第k小的结点。例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 * @author: JJGGu
 * @create: 2020-09-17 18:25
 **/
public class JZ62 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public static void main(String[] args) {
        List<TreeNode> list = new ArrayList<>();
        int [] x= {5, 3, 7, 2, 4 ,6 , 8};
        for (int i = 0; i < x.length; i++) {
            list.add(new TreeNode(x[i]));
        }

        list.get(0).left = list.get(1);
        list.get(0).right = list.get(2);
        list.get(1).left = list.get(3);
        list.get(1).right = list.get(4);
        list.get(2).left = list.get(5);
        list.get(2).right = list.get(6);
        list.get(3).left = null;
        list.get(3).right = null;
        list.get(4).left = null;
        list.get(4).right = null;
        list.get(5).left = null;
        list.get(5).right = null;
        list.get(6).left = null;
        list.get(6).right = null;

        TreeNode treeNode = KthNode(list.get(0), 3);
        System.out.println(treeNode.val);

    }

    static int i = 0;
    static TreeNode KthNode(TreeNode pRoot, int k) {
        // 中序遍历即为顺序
        if (pRoot != null) {
            TreeNode left = KthNode(pRoot.left, k);
            if (left != null) return left;
            if (++i == k) {
                return pRoot;
            }
            TreeNode right = KthNode(pRoot.right, k);
            if (right != null) {
                return right;
            }
        }

        return null;
    }
}
