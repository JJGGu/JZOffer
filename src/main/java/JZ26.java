import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;

/**
 * @program: JZOffer
 * @description: 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * @author: JJGGu
 * @create: 2020-09-11 10:45
 **/
public class JZ26 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    //方法1 使用链表按顺序保存链表节点，然后根据顺序改变链表指针
    ArrayList<TreeNode> list = new ArrayList<TreeNode>();
    public TreeNode Convert(TreeNode root) {
        saveOrder(root);
        if (list.size() == 0) {
            return null;
        }
        if (list.size() == 1) {
            return root;
        }

        list.get(0).left = null;
        list.get(0).right = list.get(1);
        for (int i = 1; i < list.size() - 1; i++) {
            list.get(i).left = list.get(i - 1);
            list.get(i).right = list.get(i + 1);
        }
        list.get(list.size() - 1).left = list.get(list.size() - 2);
        list.get(list.size() - 1).right = null;

        return list.get(0);
    }

    private void saveOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        saveOrder(root.left);
        list.add(root);
        saveOrder(root.right);
    }

    // 方法2 使用线索二叉树
    TreeNode pre = null;
    // 记录第一个节点
    TreeNode first = null;
    public TreeNode Convert2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Convert2(root.left);
        if (pre != null) {
            pre.right = root;
            root.left = pre;
        }
        if (first == null) {
            first = root;
        }
        pre = root;
        Convert2(root.right);
        return first;
    }

    // 方法3 不记录第一个节点，中序遍历 线索二叉树，只不过是先遍历右子树，再遍历左子树
    public TreeNode Convert3(TreeNode root) {
        if (root == null) {
            return null;
        }
        Convert3(root.right);
        if (pre != null) {
            pre.left = root;
            root.right = pre;
        }
        pre = root;
        Convert3(root.left);
        return pre;
    }
}
