package com.codeeval.solutions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class FirstNonRepeatedCharacter {

    public static Character findCharcater(String input) {
        HashMap<Character, Integer> counterMap = new LinkedHashMap<Character, Integer>();
        Character nonrepeatedChar = null;
        for (int i = 0; i < input.length(); i++) {
            Character character = input.charAt(i);
            int count = 1;
            if (counterMap.containsKey(character)) {
                count = counterMap.get(character) + 1;
            }
            counterMap.put(character, count);
        }

        Set<Character> keySet = counterMap.keySet();
        for (Character c : keySet) {
            int count = counterMap.get(c);
            if (count == 1) {
                nonrepeatedChar = c;
                break;
            }
        }
        return nonrepeatedChar;
    }

    public static void main(String args[]) throws Exception {

        File file = new File(
                "/Users/ravadaj/Desktop/Janardhan/Codeeval/codeeval.txt");
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            Character nonrepatedChar = findCharcater(line);
            if (nonrepatedChar != null) {
                System.out.println(nonrepatedChar);
            } else {
                throw new Exception("Non repeated character not found");
            }
        }

    }

}
