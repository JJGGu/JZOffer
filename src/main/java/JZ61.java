import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: JZOffer
 * @description: 请实现两个函数，分别用来序列化和反序列化二叉树
 * 二叉树的序列化是指：递归遍历二叉树的节点，空节点使用#代替，节点之间使用逗号隔开，返回字符串
 * 二叉树的反序列化是指：设置序号index，将字符串根据逗号分割为数组，根据index的值来设置树节点的val，如果节点的值为#，则返回空的树节点。
 * @author: JJGGu
 * @create: 2020-09-17 11:17
 **/
public class JZ61 {
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
        int [] x= {};
        for (int i = 0; i < x.length; i++) {
            list.add(new TreeNode(x[i]));
        }

//        list.get(0).left = list.get(1);
//        list.get(0).right = list.get(2);
//        list.get(1).left = list.get(3);
//        list.get(1).right = list.get(4);
//        list.get(2).left = list.get(5);
//        list.get(2).right = list.get(6);
//        list.get(3).left = null;
//        list.get(3).right = null;
//        list.get(4).left = null;
//        list.get(4).right = null;
//        list.get(5).left = null;
//        list.get(5).right = null;
//        list.get(6).left = null;
//        list.get(6).right = null;

//        String serialize = Serialize(list.get(0));
        String serialize = Serialize(null);
        System.out.println(serialize);

        TreeNode deserialize = Deserialize(serialize);
        String s = Serialize(deserialize);
        System.out.println(s);


    }

    static String Serialize(TreeNode root) {
        // 层序遍历
        if (root == null) {
            return "#";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode poll = queue.poll();
            if (poll == null) {
                stringBuilder.append("#").append(",");
            } else {
                stringBuilder.append(poll.val).append(",");
                queue.add(poll.left);
                queue.add(poll.right);
            }
        }
        return stringBuilder.toString();
    }

    static TreeNode Deserialize(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(",");

        if (split[0].equals("#")) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        queue.add(root);
        int i = 1;
        while (queue.size() > 0 && i < split.length) {
            TreeNode poll = queue.poll();
            if (split[i].charAt(0) == '#') {
                poll.left = null;
            } else {
                poll.left = new TreeNode(Integer.parseInt(split[i]));
                queue.add(poll.left);
            }
            i++;

            if (split[i].charAt(0) == '#') {
                poll.right = null;
            } else {
                poll.right = new TreeNode(Integer.parseInt(split[i]));
                queue.add(poll.right);
            }
            i++;
        }

        return root;
    }
}
