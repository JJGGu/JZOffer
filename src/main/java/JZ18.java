import java.util.Stack;

/**
 * @program: JZOffer
 * @description: 操作给定的二叉树，将其变换为源二叉树的镜像。
 * @author: JJGGu
 * @create: 2020-09-09 20:41
 **/
public class JZ18 {
    // 二叉树镜像
    public void Mirror(MyBinaryTree.TreeNode root) {
        // 递归实现，对于每一个非叶子节点，改变根节点对左右子树的指向
        // 使用后序遍历  前序遍历都可以，中序遍历不行
        if(root == null) {
            return;
        }
        Mirror(root.left);
        Mirror(root.right);

        MyBinaryTree.TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
    // 非递归实现
    public void Mirror2(MyBinaryTree.TreeNode root) {
        Stack<MyBinaryTree.TreeNode> stack = new Stack<MyBinaryTree.TreeNode>();
        if (root == null) {
            return;
        }
        stack.push(root);
        while (!stack.empty()) {
            MyBinaryTree.TreeNode treeNode = stack.pop();
            if (treeNode.left != null || treeNode.right != null) {
                // 交换指针
                MyBinaryTree.TreeNode temp = treeNode.left;
                treeNode.left = treeNode.right;
                treeNode.right = temp;
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }

        }
    }
}
