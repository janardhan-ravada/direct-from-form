package com.codeeval.solutions;

public class CountriesInAMap {

    public static boolean checkForLeftElementEquality(int[][] input,
            int[][] visited, int rowNum, int columnNum, int totalRows,
            int totalColumns) {
        boolean matched = false;
        if (columnNum - 1 >= 0 && (visited[rowNum][columnNum - 1] != 1)
                && (input[rowNum][columnNum] == input[rowNum][columnNum - 1])) {
            visited[rowNum][columnNum - 1] = 1;
            matched = true;
        }
        return matched;
    }

    public static boolean checkForRightElementEquality(int[][] input,
            int[][] visited, int rowNum, int columnNum, int totalRows,
            int totalColumns) {
        boolean matched = false;
        if ((columnNum < totalColumns - 1)
                && (visited[rowNum][columnNum + 1] != 1)
                && (input[rowNum][columnNum] == input[rowNum][columnNum + 1])) {
            visited[rowNum][columnNum + 1] = 1;
            matched = true;
        }
        return matched;
    }

    public static boolean checkForBelowElementEquality(int[][] input,
            int[][] visited, int rowNum, int columnNum, int totalRows,
            int totalColumns) {
        boolean matched = false;
        if (rowNum < totalRows - 1 && (visited[rowNum + 1][columnNum] != 1)
                && (input[rowNum][columnNum] == input[rowNum + 1][columnNum])) {
            visited[rowNum + 1][columnNum] = 1;
            matched = true;
        }
        return matched;
    }

    public static void markNeighboursVisited(int[][] input, int[][] visited,
            int rowNum, int columnNum, int totalRows, int totalColumns) {
        visited[rowNum][columnNum] = 1;

        // left element is same
        if (checkForLeftElementEquality(input, visited, rowNum, columnNum,
                totalRows, totalColumns)) {
            markNeighboursVisited(input, visited, rowNum, columnNum - 1,
                    totalRows, totalColumns);
        }
        // if right element is same
        if (checkForRightElementEquality(input, visited, rowNum, columnNum,
                totalRows, totalColumns)) {
            markNeighboursVisited(input, visited, rowNum, columnNum + 1,
                    totalRows, totalColumns);
        }
        // if below element is same

        if (checkForBelowElementEquality(input, visited, rowNum, columnNum,
                totalRows, totalColumns)) {
            markNeighboursVisited(input, visited, rowNum + 1, columnNum,
                    totalRows, totalColumns);
        }
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 },
                { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
        int totalRows = grid.length;
        int totalCols = grid[0].length;
        int visited[][] = new int[totalRows][totalCols];
        int noofconutries = 0;

        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                if (visited[i][j] != 1) {
                    markNeighboursVisited(grid, visited, i, j, totalRows,
                            totalCols);

                    noofconutries++;
                }
            }
        }
        System.out.println("noofconutries" + noofconutries);
    }

}
