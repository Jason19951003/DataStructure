package com.jason.datastructure.array;

import com.jaosn.datastructure.array.SparseArray;
import org.junit.Test;


public class SparseArrayTest {

    @Test
    public void testSparseArray() {
        // 1. 創建一個 11*11 的陣列
        int[][] array = new int[11][11];
        // 2. 將黑子與白子初始化
        array[1][2] = 1;
        array[2][3] = 2;
        array[4][3] = 2;

        // 3. 印出原始陣列，並計算非零個數。
        for(int[] row : array) {
            for (int item : row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }

        System.out.println("------------------分隔線------------------");
        // 4. 將矩陣轉為稀疏矩陣
        int[][] sparseArray = SparseArray.arrayToSparseArray(array);

        // 5. 印出稀疏矩陣
        for (int[] row : sparseArray) {
            for (int item : row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }
        System.out.println("------------------分隔線------------------");
        // 6. 將稀疏矩陣轉回原始陣列
        int[][] res = SparseArray.sparseArrayToArray(sparseArray);

        // 7. 印出原始矩陣
        for (int[] row : res) {
            for (int item : row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }
    }
}
