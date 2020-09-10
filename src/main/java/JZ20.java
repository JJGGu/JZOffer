import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: JZOffer
 * @description: 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * @author: JJGGu
 * @create: 2020-09-10 12:43
 **/
public class JZ20 {
    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
        if (stack2.empty()) {
            stack2.push(node);
            return;
        }
        if (stack2.peek() < node) {
            stack2.push(stack2.peek());
        } else {
            stack2.push(node);
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
