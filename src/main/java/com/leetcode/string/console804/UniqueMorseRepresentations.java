package com.leetcode.string.console804;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseRepresentations {
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set=new HashSet<>();
        for (String word : words) {
            set.add(getMo(word));
        }
        return set.size();
    }
    public String getMo(String word){
        String[] mo=new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        StringBuilder builder=new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            builder.append(mo[word.charAt(i)-'a']);
        }
        return  builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new UniqueMorseRepresentations().uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }
}
