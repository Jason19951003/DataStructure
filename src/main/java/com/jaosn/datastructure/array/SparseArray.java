package com.jaosn.datastructure.array;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SparseArray {

    public static void main(String[] args) throws IOException {
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
        int[][] sparseArray = arrayToSparseArray(array);

        // 5. 印出稀疏矩陣
        StringBuilder output = new StringBuilder();
        for (int[] row : sparseArray) {
            for (int item : row) {
                String format = String.format("%d\t", item);
                output.append(format);
                System.out.printf(format);
            }
            output.append("\n");
            System.out.println();
        }
        // 6. 輸出至src/main/resources/output.txt
        Path filePath = Paths.get("src/main/resources/output.txt");
        Files.writeString(filePath, output.toString());
        System.out.println("------------------分隔線------------------");

        // 7. 將稀疏矩陣轉回原始陣列
        int[][] res = sparseArrayToArray(sparseArray);

        // 8. 印出原始矩陣
        for (int[] row : res) {
            for (int item : row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }

        // 9.讀取檔案轉為稀疏矩陣
        System.out.println("------------------分隔線------------------");

        try {
            List<String> files = Files.readAllLines(filePath, StandardCharsets.UTF_8);
            int[][] result = new int[11][11];
            for (int i = 0; i < files.size(); i++) {
                String line = files.get(i);
                if (i == 0) {
                    int row = Integer.parseInt(line.split("\t")[0]);
                    int col = Integer.parseInt(line.split("\t")[1]);
                    result = new int[row][col];
                } else {
                    int x = Integer.parseInt(line.split("\t")[0]);
                    int y = Integer.parseInt(line.split("\t")[1]);
                    int z = Integer.parseInt(line.split("\t")[2]);
                    result[x][y] = z;
                }
            }

            for (int[] row : result) {
                for (int item : row) {
                    System.out.printf("%d\t", item);
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static int[][] arrayToSparseArray(int[][] array) {
        int sum = 0;
        for(int[] row : array) {
            for (int item : row) {
                if (item != 0) sum++;
            }
        }

        int[][] sparseArray = new int[sum+1][3];
        sparseArray[0][0] = array.length;
        sparseArray[0][1] = array[0].length;
        sparseArray[0][2] = sum;
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = array[i][j];
                }
            }
        }
        return sparseArray;
    }

    public static int[][] sparseArrayToArray(int[][] sparseArray) {
        int[][] res = new int[sparseArray[0][0]][sparseArray[0][1]];

        for (int i = 1; i <= sparseArray[0][2]; i++) {
            res[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        return res;
    }
}
