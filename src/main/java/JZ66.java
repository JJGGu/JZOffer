import java.lang.reflect.Array;
import java.util.*;

/**
 * @program: JZOffer
 * @description: 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * @author: JJGGu
 * @create: 2020-09-18 16:59
 **/
public class JZ66 {
    int count = 0;
    public int movingCount(int threshold, int rows, int cols) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        Integer s = new Integer(3);
        List list = new ArrayList();
        Map map = new HashMap();
        int sum = 0;
        if (threshold <= cols) {
            int x = threshold;
            for (int i = 1; i < rows; i ++) {
                sum += x;
                x -= i;
            }
        } else {
            int row = threshold - cols;
            sum *= row;

        }
        return 0;
    }
}
