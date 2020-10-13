/**
 * @program: JZOffer
 * @description:
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 *  例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 *  给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 * @author: JJGGu
 * @create: 2020-09-12 20:52
 **/
public class JZ30 {
    public static void main(String[] args) {
        int i = FindGreatestSumOfSubArray(new int[]{1,-2,3,10,-4,7,2,-5});
        System.out.println(i);
    }
    public static int FindGreatestSumOfSubArray(int[] array) {
        // 记录当前最大子序列和
        int max = array[0];
        // 记录到该点处的可能最大子序列
        int[] dp = new int[array.length];
        dp[0] = array[0];

        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
