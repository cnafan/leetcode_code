package com.leetcode.array.console1160;

public class CountCharacters {
    public static void main(String[] args) {
        System.out.println(new CountCharacters().countCharacters(new String[]{"hello","world","leetcode"}, "welldonehoneyr"));
    }

    public int countCharacters(String[] words, String chars) {
        int res=0;
        int[] charshash = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            charshash[chars.charAt(i) - 'a']++;
        }

        for (String word : words) {
            if (ishas(word, charshash)) {
                res += word.length();
            }
        }
        return res;
    }

    public boolean ishas(String word, int[] charshash) {
        int[] wordhash = new int[26];
        for (int j = 0; j < word.length(); j++) {
            wordhash[word.charAt(j) - 'a']++;
        }
        for (int i = 0; i < wordhash.length; i++) {
            if (wordhash[i] > charshash[i]) {
                return false;
            }
        }
        return true;
    }
}
