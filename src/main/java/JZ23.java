/**
 * @program: JZOffer
 * @description: 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。
 * @author: JJGGu
 * @create: 2020-09-10 16:07
 **/
public class JZ23 {
    private boolean recur(int[] arr, int start, int end) {
        // 递归判断 子树是不是符合条件
        // 最后一个值将当前树分为 左子树和右子树
        if (start >= end) {
            return true;
        }
        int rootVal = arr[end];
        int i = start;
        while (i < end && arr[end] > arr[i]){
            i++;
        }

        // 右子树判断是否有小于根的值
        for (int j = i; j <= end; j++) {
            if (arr[j] < rootVal){
                return false;
            }
        }
        return recur(arr, start, i - 1) && recur(arr, i, end - 1);
    }
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        return recur(sequence, 0, sequence.length - 1);
    }
}
