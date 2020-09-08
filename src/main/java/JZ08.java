/**
 * @program: JZOffer
 * @description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * @author: JJGGu
 * @create: 2020-09-08 19:45
 **/
public class JZ08 {
    public static void main(String[] args) {

    }

    public static int JumpFloor(int target) {
        // 这里注意与斐波那契数列的区别，当 n 为0的时候，有一种方法
        if (target == 0) {
            return 1;
        }
        if (target == 1){
            return 1;
        }
        int[] arr = new int[target + 1];
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i <= target; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[target];
    }

}
