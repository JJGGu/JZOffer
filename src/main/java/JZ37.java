import java.util.*;

/**
 * @program: JZOffer
 * @description: 统计一个数字在升序数组中出现的次数。
 * @author: JJGGu
 * @create: 2020-09-14 21:48
 **/
public class JZ37 {
    public static void main(String[] args) {
        int i = GetNumberOfK(new int[]{1,2,3,3,3,3}, 3);
        System.out.println(i);
    }
    public static int GetNumberOfK(int[] array , int k) {
        int index = Arrays.binarySearch(array, k);
        if(index<0) {
            return 0;
        }
        int cnt = 1;
        for(int i=index+1; i < array.length && array[i]==k;i++){
            cnt++;

        }
        for(int i=index-1; i >= 0 && array[i]==k;i--) {
            cnt++;
        }
        return cnt;
    }
}
