/**
 * @program: JZOffer
 * @description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author: JJGGu
 * @create: 2020-09-08 20:15
 **/
public class JZ09 {
    public static void main(String[] args) {
        System.out.println(JumpFloorII(5));
//        System.out.println(JumpFloorII2(5));
    }
    //  暴力解法
    public static int JumpFloorII(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1){
            return 1;
        }
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                arr[i] += arr[j];
            }
        }
        return arr[n];
    }

    // 递推法
    public static int JumpFloorII2(int n){
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] << 1;
        }
        return arr[n];
    }
}
