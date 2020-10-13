/**
 * @program: JZOffer
 * @description: 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * @author: JJGGu
 * @create: 2020-09-18 15:41
 **/
public class JZ65 {
    boolean[] visited = null;

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        visited = new boolean[matrix.length];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (subHasPath(matrix, rows, cols, str, i, j, 0))
                    return true;
        return false;
    }

    public boolean subHasPath(char[] matrix, int rows, int cols, char[] str, int row, int col, int len) {
        if (matrix[row * cols + col] != str[len] || visited[row * cols + col] == true) {
            return false;
        }
        if (len == str.length - 1) {
            return true;
        }
        visited[row * cols + col] = true;
        if (row > 0 && subHasPath(matrix, rows, cols, str, row - 1, col, len + 1)) {
            return true;
        }
        if (row < rows - 1 && subHasPath(matrix, rows, cols, str, row + 1, col, len + 1)) {
            return true;
        }
        if (col > 0 && subHasPath(matrix, rows, cols, str, row, col - 1, len + 1)) {
            return true;
        }
        if (col < cols - 1 && subHasPath(matrix, rows, cols, str, row, col + 1, len + 1)) {
            return true;
        }
        // 说明条件不满足，置为未走过
        visited[row * cols + col] = false;
        return false;
    }
}
