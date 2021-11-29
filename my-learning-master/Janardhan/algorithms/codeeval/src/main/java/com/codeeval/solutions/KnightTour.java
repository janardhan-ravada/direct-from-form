package com.codeeval.solutions;

public class KnightTour {

    private static int[] xmoves = { 2, 1, -1, -2, -2, -1, 1, 2 };
    private static int[] ymoves = { 1, 2, 2, 1, -1, -2, -2, -1 };
    private static int count = 1;

    public static boolean knightTour(int[][] input, int x, int y, int n) {
        if (count == n * n)
            return true;
        else {
            for (int j = 0; j < 8; j++) {
                int nextXmove = x + xmoves[j];
                int nextyMove = y + ymoves[j];
                if (isValidMove(input, nextXmove, nextyMove, n)) {
                    input[x][y] = count++;
                    if (knightTour(input, nextXmove, nextyMove, n)) {
                        return true;
                    } else {
                        count--;
                        input[x][y] = -1;
                    }
                }
            }
        }
        return false;
    }

    private static boolean isValidMove(int[][] input, int i, int j, int n) {
        if (i < n && i >= 0 && j >= 0 && j < n && input[i][j] < 0)
            return true;
        else
            return false;
    }

    public static void main(String args[]) {
        int n = 8;
        int[][] input = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                input[i][j] = -1;
            }
        }
        knightTour(input, 0, 0, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(input[i][j] + "    ");
            }
            System.out.println();
        }
    }
}
