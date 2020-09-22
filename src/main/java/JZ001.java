/**
 * @program: JZOffer
 * @description:  在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author: JJGGu
 * @create: 2020-09-21 21:28
 **/
public class JZ001 {
    public static void main(String[] args) {
        int [][] array = {
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}
        };

        System.out.println(Find2(1, array));
    }

    // 从左下角开始
    public static boolean Find(int target, int [][] array) {
        if (array[0].length == 0) {
            return false;
        }
        int i = array.length - 1;
        int j = 0;

        while (i >= 0 && j < array[0].length) {
            if (target > array[i][j]) {
                j++;
            } else if (target < array[i][j]){
                i--;
            } else {
                return true;
            }
        }

        return false;
    }


    // 从右上角开始
    public static boolean Find2(int target, int [][] array) {
        if (array[0].length == 0) {
            return false;
        }
        int i = 0;
        int j = array[0].length - 1;

        while (i < array.length && j >= 0) {
            if (target > array[i][j]) {
                i++;
            } else if (target < array[i][j]) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }
}
