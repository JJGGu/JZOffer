/**
 * @program: JZOffer
 * @description: 汇编语言中有一种移位指令叫做循环左移（ROL），
 * 现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 * @author: JJGGu
 * @create: 2020-09-15 17:02
 **/
public class JZ43 {
    public static void main(String[] args) {
        System.out.println(LeftRotateString("abcXYZdef", 3));
    }
    // 翻转法
    public static String LeftRotateString(String str,int n) {
        if (str.length() <= 1 || n == 0) {
            return str;
        }

        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, str.length() - 1);
        reverse(chars, 0, str.length() - 1);
        return new String(chars);
    }
    public static void reverse(char[] str, int start, int end) {
        int mid = (start + end) / 2;
        while (end != mid) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
}
