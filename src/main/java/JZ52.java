import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

/**
 * @program: JZOffer
 * @description: 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * @author: JJGGu
 * @create: 2020-09-16 13:48
 **/
public class JZ52 {
    public static void main(String[] args) {
        String s1 = "&39;";
        String s2 = "ff";
        System.out.println(match(s1.toCharArray(), s2.toCharArray()));
    }
    public static boolean match(char[] str, char[] pattern) {
        int top1 = -1;
        char[] stack1 = new char[pattern.length];
        // 入栈
        for (char c : pattern) {
            top1++;
            stack1[top1] = c;
        }

        int top2 = -1;
        char[] stack2 = new char[str.length];
        for (char c : str) {
            top2++;
            stack2[top2] = c;
        }
        // 出栈
        int flag = 0;
        while (top2 >= 0 && top1 >= 0) {
            char a = stack1[top1]; // pattern
            char b = stack2[top2]; // str
            if (a == b || a == '.') {
                top1--;
                top2--;
                continue;
            }
            if (a == '*') {
                // 记录下一个*所在的位置
                int temp = top1;
                while (stack1[top1] != b) {
                    top1--;
                    if (top1 < 0) {
                        return false;
                    }
                    if (stack1[top1] == '*') {
                        if (flag == 0) {
                            temp = top1;
                            flag = 1;
                        }
                    }
                }
                // 找到了*之前有该值
                top1--;
                top2--;
                if (flag == 1) {
                    top1 = temp;
                    flag = 0;
                }

            }
        }

        if (top2 == -1 && top1 == -1) {
            return true;
        }
        return false;
    }
}
