/**
 * @program: JZOffer
 * @description: 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * @author: JJGGu
 * @create: 2020-09-07 20:54
 **/
public class JZ04 {


    public static void main(String[] args) {

    }

    public static MyBinaryTree.TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return rebuild(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }
    private static MyBinaryTree.TreeNode rebuild(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd){
        if (preStart > preEnd){
            return null;
        }
        int rootIndex = preStart;
        MyBinaryTree.TreeNode root = new MyBinaryTree.TreeNode(pre[rootIndex]);
        // 找到该值在中序中的index
        int t = inStart;
        while(pre[rootIndex] != in[t++]){}
        --t;

        // 建立左子树，右子树
        root.left = rebuild(pre, rootIndex + 1, rootIndex + t - inStart, in, inStart, t - 1);
        root.right = rebuild(pre, rootIndex + 1 + t - inStart, preEnd, in, t + 1, inEnd);
        return root;
    }
}
