package com.codeeval.solutions;

public class TwentyForghtyEight {

    public static void shift(int[] data) {
        int size = data.length;
        for (int i = size - 1; i > 0; i--) {
            int j = i;
            while (j > 0 && data[j] == 0) {
                data[j] = data[j - 1];
                data[j - 1] = 0;
                j--;
            }
        }
    }

    public static void gridSum(int[] data) {
        int i = data.length - 1;
        while (i > 0) {
            if (data[i] == data[i - 1]) {
                data[i] = 2 * data[i];
                data[i - 1] = 0;
            }
            i--;
        }
    }

    public static void main(String[] args) {
        int[][] grid = { { 0, 4, 0, 2, 0 }, { 0, 0, 0, 0, 8 },
                { 0, 4, 0, 2, 4 }, { 0, 2, 4, 2, 2 } };

        int[] temp = new int[5];
        String dir = "right";
        switch (dir) {
        case "up":
            int ind = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = grid[0].length - 1; j > 0; j--) {
                    temp[ind] = grid[j][i];
                    ind++;
                }
                for (int k = 0; k < temp.length; k++) {
                    System.out.print(temp[k] + "\t");
                }
                System.out.println("\n");
                ind = 0;
            }
            break;
        case "down":
            ind = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    temp[ind] = grid[j][i];
                    ind++;
                }
                shift(temp);
                gridSum(temp);
                shift(temp);
                for (int k = 0; k < temp.length; k++) {
                    System.out.println(temp[k]);
                }
                System.out.println("\n");
                ind = 0;
            }
            break;
        case "right":
            ind = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    temp[ind] = grid[i][j];
                    ind++;
                }
                shift(temp);
                gridSum(temp);
                shift(temp);
                for (int k = 0; k < temp.length; k++) {
                    System.out.print(temp[k] + "\t");
                }
                System.out.println("\n");
                ind = 0;
            }
            break;
        case "left":
            ind = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = grid[0].length - 1; j >= 0; j--) {
                    temp[ind] = grid[i][j];
                    ind++;
                }
                shift(temp);
                gridSum(temp);
                shift(temp);
                for (int k = 0; k < temp.length; k++) {
                    System.out.print(temp[k] + "\t");
                }
                System.out.println("\n");
                ind = 0;
            }
            break;
        }
    }

}
