import java.util.Stack;

/**
 * @program: JZOffer
 * @description: 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @author: JJGGu
 * @create: 2020-09-08 10:21
 **/
public class JZ05 {
    static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();

//    ["PSH1","PSH2","PSH3","POP","POP","PSH4","POP","PSH5","POP","POP"]
    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        System.out.println(pop());
        System.out.println(pop());
        push(4);
        System.out.println(pop());
        push(5);
        System.out.println(pop());
        System.out.println(pop());

    }

    public static void push(int node) {
        // 先存到一个栈中然后弹出后再存到另外一个栈中
        stack1.push(node);
    }

    public static int pop() {
        // 从stack2中pop
        if (stack2.empty()){
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        } else {
            return stack2.pop();
        }
        return stack2.pop();
    }
}
