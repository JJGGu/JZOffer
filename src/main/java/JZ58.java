import java.util.ArrayList;
import java.util.List;

/**
 * @program: JZOffer
 * @description: 请实现一个函数，用来判断一棵二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * @author: JJGGu
 * @create: 2020-09-16 22:08
 **/
public class JZ58 {
    public static void main(String[] args) {
        List<TreeNode> list = new ArrayList<>();
        int [] x= {8, 6, 9,5, 7, 7, 5};
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

        boolean symmetrical = isSymmetrical(list.get(0));
        System.out.println(symmetrical);
    }
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    static boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isSame(pRoot.left, pRoot.right);
    }
    static boolean isSame(TreeNode r1, TreeNode r2) {
        if (r1 == null) {
            return r2 == null;
        }
        if (r2 == null) {
            return false;
        }
        boolean a = r1.val == r2.val;
        return a && isSame(r1.left, r2.right) && isSame(r1.right, r2.left);
    }

}
