/**
 * @program: JZOffer
 * @description: 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * @author: JJGGu
 * @create: 2020-09-15 19:15
 **/
public class JZ48 {
    public static void main(String[] args) {
        System.out.println(Add(-1, 6));
    }
    // &进位  ^无进位
    // 正整数
    public static int Add(int num1,int num2) {
        while (num2 != 0) {
            // 负数左移会在低位补1，所以转化为无符号整数
            int c = ((num1 & num2)) << 1;
            num1 ^= num2;
            num2 = c;
        }
        return num1;
    }

}
