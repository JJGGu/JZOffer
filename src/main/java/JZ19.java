import java.util.ArrayList;
import java.util.List;

/**
 * @program: JZOffer
 * @description:
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @author: JJGGu
 * @create: 2020-09-09 21:31
 **/
public class JZ19 {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
//        System.out.println(arr.length);
//        System.out.println(arr[0].length);
        ArrayList<Integer> arrayList = printMatrix(arr);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int height = matrix.length;
        if (height == 0) {
            return list;
        }
        int width = matrix[0].length;

        // 初始四个方向
        int right = 0;
        int down = 0;
        int left = width - 1;
        int up = height - 1;

        while (true) {
            // right
            for (int col = right; col <= left; col++) {
                list.add(matrix[down][col]);
             }
            down++;
            if (down > up) {
                break;
            }
            // down
            for (int row = down; row <= up; row++) {
                list.add(matrix[row][left]);
            }
            left--;
            if (left < right) {
                break;
            }
            // left
            for (int col = left; col >= right; col--) {
                list.add(matrix[up][col]);
            }
            up--;
            if (up < down) {
                break;
            }
            // up
            for (int row = up; row >= down; row--) {
                list.add(matrix[row][right]);
            }
            right++;
            if (right > left) {
                break;
            }
        }
        return list;
    }
}

