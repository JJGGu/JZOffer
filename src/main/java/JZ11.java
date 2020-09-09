/**
 * @program: JZOffer
 * @description: 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 * 负数补码为原码最低位加1
 * @author: JJGGu
 * @create: 2020-09-08 21:13
 **/
public class JZ11 {
    public static void main(String[] args) {
        System.out.println(NumberOf1(7));
    }
    public static int NumberOf1(int n) {
        String s = Integer.toBinaryString(n);
        String[] split = s.split("");
        int count = 0;
        for (int i = 0; i < split.length; i++) {
            if (Integer.parseInt(split[i]) == 1){
                count++;
            }
        }
        return count;
    }

}
