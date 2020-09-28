import java.util.*;

/**
 * @program: JZOffer
 * @description: 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * @author: JJGGu
 * @create: 2020-09-25 14:47
 **/
public class JZ059 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    // 思路1. 使用队列，打出每一层的值
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        // 层序遍历
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> arrayList = new ArrayList<>();
            // 全都出队
            while (size > 0) {
                TreeNode poll = queue.poll();
                arrayList.add(poll.val);

                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                size--;
            }

            level++;
            result.add(arrayList);
            if ((level & 1) == 1) {
                // 反转队列 或者反转arrayList也可以
                Stack<TreeNode> stack = new Stack<>();
                while (!queue.isEmpty()) {
                    stack.push(queue.poll());
                }
                while (!stack.empty()) {
                    queue.offer(stack.pop());
                }
            }
        }

        return result;
    }

    // 思路二 使用两个栈
}
