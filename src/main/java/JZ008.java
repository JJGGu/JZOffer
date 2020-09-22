/**
 * @program: JZOffer
 * @description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
 * @author: JJGGu
 * @create: 2020-09-22 13:55
 **/
public class JZ008 {

    public static void main(String[] args) {
        System.out.println(JumpFloor(5));
    }

    public static int JumpFloor(int target) {
        if (target == 0 || target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int[] a = new int[target + 1];
        a[0] = 1;
        a[1] = 1;
        for (int i = 2; i <= target; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[target];
    }
}
