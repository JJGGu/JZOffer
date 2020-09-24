import java.util.ArrayList;

/**
 * @program: JZOffer
 * @description: * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @author: JJGGu
 * @create: 2020-09-24 10:52
 **/
public class JZ019 {
    public static void main(String[] args) {
        int[][] arr = {
                {1}, {2}, {3}
        };
//        System.out.println(arr.length);
//        System.out.println(arr[0].length);
        ArrayList<Integer> arrayList = printMatrix(arr);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (matrix[0].length == 0) {
            return arrayList;
        }
        int all = matrix.length * matrix[0].length;
        int count = 0;
        int i = 0;
        int j = 0;
        // 边界
        int left = 0;
        int right = matrix[0].length - 1;
        int up = 1;
        int down = matrix.length - 1;
        while (true) {
            while (j <= right) {
                arrayList.add(matrix[i][j]);
                count++;
                j++;
            }
            j--;
            i++;
            right--;
            if (count == all) {
                break;
            }
            while (i <= down) {
                arrayList.add(matrix[i][j]);
                count++;

                i++;
            }
            i--;
            j--;
            down--;
            if (count == all) {
                break;
            }
            while (j >= left) {
                arrayList.add(matrix[i][j]);
                count++;

                j--;
            }
            j++;
            i--;
            left++;
            if (count == all) {
                break;
            }
            while (i >= up) {
                arrayList.add(matrix[i][j]);
                count++;
                i--;
            }
            i++;
            j++;
            up++;
            if (count == all) {
                break;
            }
        }
        return arrayList;
    }
}
