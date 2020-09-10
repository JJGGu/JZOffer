import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: JZOffer
 * @description: 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * @author: JJGGu
 * @create: 2020-09-10 15:47
 **/
public class JZ22 {
    // 层序遍历
    public ArrayList<Integer> PrintFromTopToBottom(MyBinaryTree.TreeNode root) {
        Queue<MyBinaryTree.TreeNode> queue = new LinkedList<MyBinaryTree.TreeNode>();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (root == null) {
            return arrayList;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            MyBinaryTree.TreeNode cur = queue.remove();
            arrayList.add(cur.val);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        return  arrayList;
    }
}
