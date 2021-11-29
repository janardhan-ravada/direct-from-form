package com.codeeval.solutions;

public class Modulous {

    public static int mod(int n, int m) {

        int dividend = n / m;
        int mod = n - (dividend * m);
        return mod;
    }
}
