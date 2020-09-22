/**
 * @program: JZOffer
 * @description: 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * @author: JJGGu
 * @create: 2020-09-21 22:27
 **/
public class JZ004 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
        TreeNode(){}
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return create(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }
    private TreeNode create(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        // 1.找到分割的点
        int index = inStart;
        int rootIndex = preStart;
        TreeNode root = new TreeNode(pre[rootIndex]);

        while (pre[rootIndex] != in[index]) {
            index++;
        }
        root.left = create(pre, rootIndex + 1, rootIndex + index - inStart, in, inStart, index - 1);
        root.right = create(pre, rootIndex + 1 + index - inStart, preEnd, in, index + 1, inEnd);
        return root;
    }
}
