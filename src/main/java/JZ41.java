import java.util.ArrayList;

/**
 * @program: JZOffer
 * @description: 小明很喜欢数学, 有一天他在做数学作业时, 要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * @author: JJGGu
 * @create: 2020-09-15 13:56
 **/
public class JZ41 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrayLists = FindContinuousSequence2(15);
        System.out.println(arrayLists);
    }
    // 1.暴力解法
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 1; i < sum / 2 + 1; i++) {
            int temp = 0;
            ArrayList<Integer> arrayList = new ArrayList<>();

            for (int j = i; j < sum; j++) {
                temp += j;
                arrayList.add(j);
                if (temp == sum) {
                    result.add(arrayList);
                }
                if (temp >= sum) {
                    break;
                }
            }
        }
        return result;
    }

    // 2。滑动窗口法
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence2(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int left = 1;
        int right = 1;
        int temp = 0;
        for (int i = 0; i <= sum / 2 + 1; i++) {
            if (temp < sum) {
                temp += right;
                right++;
            }
            if (temp > sum) {
                temp -= left;
                left++;

            }
            if (temp == sum) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int j = left; j < right; j++) {
                    arrayList.add(j);
                }
                if (arrayList.size() > 1) {
                    result.add(arrayList);
                }
                temp -= left;
                left++;
            }
        }
        return result;
    }
}
