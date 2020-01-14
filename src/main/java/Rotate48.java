/**
 * 48. 旋转图像
 *
 * @author avatarannappa
 * @version 1.0, 2020/1/6
 */
public class Rotate48 {
    public void rotate(int[][] matrix) {
        int l = matrix.length;
        int harf = l / 2;
        int harfy = harf;
        int length = l - 1;
        if (l == 1) {
            return;
        }

        if (l % 2 == 1) {
            harfy++;
        }

        for (int i = 0; i < harf; i++) {
            for (int j = 0; j < harfy; j++) {
                int a = i;
                int b = j;
                int front = matrix[a][b];
                int after = matrix[b][length - a];
                matrix[b][length - a] = front;
                int tempIndex = a;
                a = b;
                b = length - tempIndex;

                front = after;
                after = matrix[b][length - a];
                matrix[b][length - a] = front;
                tempIndex = a;
                a = b;
                b = length - tempIndex;

                front = after;
                after = matrix[b][length - a];
                matrix[b][length - a] = front;
                tempIndex = a;
                a = b;
                b = length - tempIndex;

                front = after;
                after = matrix[b][length - a];
                matrix[b][length - a] = front;
                tempIndex = a;
                a = b;
                b = length - tempIndex;
            }
        }
    }

    public static void main(String[] args) {
        // int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new Rotate48().rotate(matrix);
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt);
                System.out.print(",");
            }
            System.out.println("");
        }
        System.out.println(3 / 2);
        System.out.println(5 / 2);
        System.out.println(7 / 2);
    }
}
