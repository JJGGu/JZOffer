/**
 * @program: JZOffer
 * @description:
 * @author: JJGGu
 * @create: 2020-09-07 21:08
 **/
public class MyBinaryTree {
    public TreeNode root = new TreeNode();
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
        TreeNode(){}
    }


    public boolean insert(int data) {
        TreeNode newTreeNode = new TreeNode(data);
        if(root == null){//当前树为空树，没有任何节点
            root = newTreeNode;
            return true;
        }else{
            TreeNode current = root;
            TreeNode parentTreeNode = null;
            while(current != null){
                parentTreeNode = current;
                if(current.val > data){//当前值比插入值大，搜索左子节点
                    current = current.left;
                    if(current == null){//左子节点为空，直接将新值插入到该节点
                        parentTreeNode.left = newTreeNode;
                        return true;
                    }
                }else{
                    current = current.right;
                    if(current == null){//右子节点为空，直接将新值插入到该节点
                        parentTreeNode.right = newTreeNode;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);

    }
}
