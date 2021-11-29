package com.codeeval.solutions;

public class Sodoku {

    public static int[] findUnassigned(int[][] input) {
        int[] unAssigned = new int[2];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (input[i][j] == 0) {
                    unAssigned[0] = i;
                    unAssigned[1] = j;
                    return unAssigned;
                }
            }
        }
        return null;
    }

    public static boolean solveSudoku(int[][] input) {
        int[] unassigned = findUnassigned(input);
        if (unassigned == null) {
            return true;
        } else {
            int row = unassigned[0];
            int col = unassigned[1];
            for (int i = 1; i <= 9; i++) {
                if (isSafe(input, row, col, i)) {
                    input[row][col] = i;
                    if (solveSudoku(input)) {
                        return true;
                    }
                    input[row][col] = 0;
                }
            }
            return false;
        }
    }

    public static boolean isSafe(int[][] input, int rowNum, int colNum,
            int num) {
        return duplicateInRow(input, rowNum, num)
                && duplicateInColumn(input, colNum, num)
                && duplicateInBox(input, rowNum, colNum, num);
    }

    public static boolean duplicateInRow(int[][] input, int rownum, int num) {
        for (int j = 0; j < input.length; j++) {
            if (input[rownum][j] == num)
                return false;
        }
        return true;
    }

    public static boolean duplicateInColumn(int[][] input, int colNum,
            int num) {
        for (int i = 0; i < input.length; i++) {
            if (input[i][colNum] == num)
                return false;
        }
        return true;
    }

    public static boolean duplicateInBox(int[][] input, int rowNum, int colNum,
            int num) {
        int boxStartRow = rowNum - (rowNum % 3);
        int boxStartCol = colNum - (colNum % 3);

        for (int i = boxStartRow; i < boxStartRow + 3; i++) {
            for (int j = boxStartCol; j < boxStartCol + 3; j++) {
                if (input[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean completelyFilled(int grid[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0)
                    return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        int grid[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 }, { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

        if (solveSudoku(grid))
            System.out.println("solved");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(grid[i][j] + "    ");
            }
            System.out.println();
        }
    }
}
