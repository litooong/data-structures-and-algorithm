package litooong.com.github.medium;

/**
 * No.74 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 */
public class SearchMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        // 1. 找到目标行 matrix[i][]
        // matrix[0][0] ~ matrix[matrix.length - 1][0]
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][0];
        }
        int targetRow = 0;
        if (column.length == 1) {
            if (target < column[0] || target > matrix[0][matrix[0].length - 1]) {
                return false;
            } else {
                targetRow = 0;
            }
        } else {
            // 二分法找到目标行
            int low = 0;
            int high = column.length - 1;
            int middle;
            while (high >= low) {
                middle = (low + high) / 2;
                if (target == column[middle]) {
                    return true;
                }
                if (target > column[middle]) {
                    low = middle + 1;
                }
                if (target < column[middle]) {
                    high = middle - 1;
                }
            }
            if (high >= 0) {
                targetRow = high;
            } else {
                return false;
            }

        }

        // 对目标行数组使用二分法查找是否存在
        int[] targetArr = matrix[targetRow];
        int low = 0;
        int high = targetArr.length - 1;
        int middle;
        while (high >= low) {
            middle = (low + high) / 2;
            if (target == targetArr[middle]) {
                return true;
            }
            if (target > targetArr[middle]) {
                low = middle + 1;
            }
            if (target < targetArr[middle]) {
                high = middle - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 13, 16}}, 3));
    }

}
