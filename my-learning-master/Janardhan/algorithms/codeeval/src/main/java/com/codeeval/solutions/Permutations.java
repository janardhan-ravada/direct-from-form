package com.codeeval.solutions;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void swap(StringBuilder s, int pos1, int pos2) {
        String ch1 = s.substring(pos1, pos1 + 1);
        String ch2 = s.substring(pos2, pos2 + 1);
        s.replace(pos1, pos1 + 1, ch2);
        s.replace(pos2, pos2 + 1, ch1);
    }

    public static void permute(StringBuilder s, int start, int length,
            List<String> permutations) {
        if (start >= length - 1) {
            permutations.add(s.toString());
        } else {
            for (int i = start; i < length; i++) {
                swap(s, start, i);
                permute(s, start + 1, length, permutations);
                swap(s, start, i);
            }
        }
    }

    public static void main(String args[]) {
        StringBuilder s = new StringBuilder("abcd");
        List<String> permutations = new ArrayList<String>();
        permute(s, 0, s.length(), permutations);
        for (String str : permutations) {
            System.out.println(str);
        }
    }
}
