import java.util.Stack;

/**
 * @program: JZOffer
 * @description: 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * @author: JJGGu
 * @create: 2020-09-24 15:31
 **/
public class JZ021 {
    public static void main(String[] args) {
        int [] arr1 = {1, 2, 3, 4, 5};
        int [] arr2 = {4, 5, 3, 2, 1};
        boolean b = IsPopOrder(arr1, arr2);
        System.out.println(b);
    }

    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length != popA.length) {
            return false;
        }
        if (pushA.length == 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        // 模拟
        int i = 0;
        int j = 0;
        // 进栈
        stack.push(pushA[i]);
        i++;
        while (j < popA.length) {
            // 不相等则进栈，否则出栈
            if (popA[j] == stack.peek()) {
                stack.pop();
                j++;
            } else {
                if (i == pushA.length) {
                    break;
                }
                stack.push(pushA[i]);
                i++;
            }
        }
        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }
}
