import java.util.Stack;

/**
 * @program: JZOffer
 * @description:
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 * @author: JJGGu
 * @create: 2020-09-10 15:02
 **/
public class JZ21 {
    public static void main(String[] args) {
        int [] arr1 = {1, 2, 3, 4, 5};
        int [] arr2 = {4, 5, 3, 2, 1};
        boolean b = IsPopOrder(arr1, arr2);
        System.out.println(b);
    }

    // 模拟出栈与入栈
    public static boolean IsPopOrder(int [] pushA, int [] popA) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int j = 0;
        while (j < popA.length && i < pushA.length) {
            if (pushA[i] != popA[j]) {
                stack.push(pushA[i]);
                ++i;
            } else {
                ++i;
                ++j;
                while (!stack.empty() && stack.peek() == popA[j]) {
                    stack.pop();
                    ++j;
                }
            }
        }
        if (stack.empty()) {
            return true;
        }
        return false;
    }
}
