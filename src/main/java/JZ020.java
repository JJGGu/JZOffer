import java.util.Stack;


/**
 * @program: JZOffer
 * @description: 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * @author: JJGGu
 * @create: 2020-09-24 13:25
 **/
public class JZ020 {

    // 正常的栈
    public Stack<Integer> stack1 = new Stack<>();
    // 记录最小值在上面的栈
    public Stack<Integer> stack2 = new Stack<>();
    public void push(int node) {
        stack1.push(node);
        if (stack2.size() == 0 || node < stack2.peek()) {
            stack2.push(node);
        } else {
            stack2.push(min());
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();

    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
