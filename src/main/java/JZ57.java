/**
 * @program: JZOffer
 * @description: 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * @author: JJGGu
 * @create: 2020-09-16 17:41
 **/
public class JZ57 {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        // 有以下情况
        // 1.当前节点有右子树，下一个节点是该右子树最左面的节点
        // 3.当前节点没有右子树且该节点是其父节点的左孩子，下一个节点是父节点
        // 4.当前节点没有右子树且该节点是其父节点的右孩子，下一个节点是上面的某一个节点，该节点的左子树是pNode的祖父
        // 2.当前节点没有右子树，下一个节点是null

        TreeLinkNode temp = pNode;
        if (pNode.right != null) {
            temp = temp.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        }
        if (pNode.right == null) {
            if (pNode.next == null) {
                return null;
            }
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            if (pNode.next.right == pNode) {
                while (temp.next != null && temp.next.left != temp) {
                    temp = temp.next;
                }
                return temp.next;
            }
        }

       return null;

    }
}
