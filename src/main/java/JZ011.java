/**
 * @program: JZOffer
 * @description: 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 * @author: JJGGu
 * @create: 2020-09-23 15:46
 **/
public class JZ011 {
    public static void main(String[] args) {
        System.out.println(NumberOf2(-6));
    }
    // 对于负数还是有问题
    public static int NumberOf1(int n) {
        int a = 0x01;
        int count = 0;
        while (n > 0) {
            if ((n & a) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }

    // 从右向左与运算
    public static int NumberOf2(int n) {
        int mask = 0x01;
        int count = 0;
        while (mask != 0) {
            if ((n & mask) != 0) {
                count++;
            }
            mask <<= 1;
        }
        return count;
    }
}
