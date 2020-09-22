/**
 * @program: JZOffer
 * @description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author: JJGGu
 * @create: 2020-09-22 14:05
 **/
public class JZ009 {
    public static void main(String[] args) {
        System.out.println(Jump(3));
    }

    public static int JumpFloorII(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        int[] a = new int[n + 1];
        a[0] = 1;
        a[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                a[i] += a[j];
            }
        }
        return a[n];
    }

    public static int Jump(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        int[] a = new int[n + 1];
        a[0] = 1;
        a[1] = 1;
        for (int i = 2; i <= n; i++) {
            a[i] = a[i - 1] << 1;
        }
        return a[n];
    }
}
