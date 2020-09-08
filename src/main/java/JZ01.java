/**
 * @program: JZOffer
 * @description: 题目描述
 *  * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author: JJGGu
 * @create: 2020-09-06 09:52
 **/
public class JZ01 {
    public static void main(String[] args) {
//        System.out.println(Find());
        System.out.println(Find2());
    }

    public static boolean Find(){
        int target = 7;
        int [][] array = {
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}
        };

        if (array.length == 0) {
            return false;
        }

        for (int i = 0; i < array.length; ++i){
            int j_start = 0, j_end = array[0].length - 1;

            while (j_start <= j_end){
                int j_mid = (j_start + j_end) / 2;
                if (target == array[i][j_mid]){
//                        System.out.println("i：" + mid_i);
//                        System.out.println("j: " + j_mid);
                    return true;
                }
                if (target < array[i][j_mid]){
                    // 在左边
                    j_end = j_mid - 1;
                } else if (target > array[i][j_mid]){
                    j_start = j_mid + 1;
                }
            }

        }
        return false;
    }

    // 方法2 从最左下角开始，每次只可以上移或者右移，复杂度为o(n)
    public static boolean Find2(){
        int target = 7;
        int [][] array = {
                {}
        };
        if (array[0].length == 0) {
            return false;
        }
        // 左下角坐标
        int i = array.length - 1;
        int j = 0;

        for (int k = 0; k < Math.max(array.length, array[0].length); k++) {
            int value = array[i][j];
            if (value == target){
                return true;
            }
            if (target < value){
                // 上移
                if (--i < 0){
                    return false;
                }
                continue;
            }
            if (target > value) {
                // 右移
                if (++j > array[0].length){
                    return false;
                }
            }
        }
        return false;
    }
}
