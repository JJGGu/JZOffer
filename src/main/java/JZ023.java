import java.util.Arrays;

/**
 * @program: JZOffer
 * @description: 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。
 * @author: JJGGu
 * @create: 2020-09-24 16:01
 **/
public class JZ023 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return judge(sequence, 0, sequence.length - 1);

    }
    // 递归判断左子树和右子树是否符合二叉搜索树的特点，即左子树比根节点小，右子树比根节点大
    private boolean judge(int[] a, int start, int end) {
        if (start >= end) {
            return true;
        }
        // 先根据后序数组找到分割点
        int i = start;
        while (a[i] < a[end]) {
            i++;
        }
        // 判读后面的值是否都大于a[i]
        int j = i;
        while (j < end) {
            if (a[j] < a[end]) {
                return false;
            }
            j++;
        }
        return judge(a, start, i - 1) && judge(a, i, end - 1);
    }
}
