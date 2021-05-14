package com.leetcode.string.console1408;

import java.util.ArrayList;
import java.util.List;

public class StringMatching {
    public List<String> stringMatching(String[] words) {
        int[] count=new int[words.length];
        List<String> list=new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (isMatch(words[i],words[j])){
                    count[i]=1;
                }
            }
        }
        for (int i = 0; i < words.length; i++) {
            if (count[i]==1){
                list.add(words[i]);
            }
        }
        return list;
    }

    public boolean isMatch(String word1,String word2){
        if (word1.length()>=word2.length()){
            return false;
        }else {
            return word2.contains(word1);
        }
    }
    public static void main(String[] args) {
        System.out.println(new StringMatching().stringMatching(new String[]{"leetcoder","leetcode","od","hamlet","am"}));
    }

}
