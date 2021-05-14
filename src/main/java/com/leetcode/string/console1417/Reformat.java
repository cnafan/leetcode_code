package com.leetcode.string.console1417;

public class Reformat {
    public static void main(String[] args) {
        System.out.println(new Reformat().reformat("covid2019"));
    }
    public String reformat(String s) {
        int number=0,character=0;
        char[] temp=new char[s.length()];
        char[] chars=s.toCharArray();
        for (char c: chars) {
            if (c>='0'&&c<='9')number++;
            else character++;
        }
        if (Math.max(number,character)-Math.min(number,character)==1||number==character){

            if (number>character){
                number=0;
                character=1;
            }else {
                number=1;
                character=0;
            }
            for (char aChar : chars) {
                if (aChar >= '0' && aChar <= '9') {
                    temp[number] = aChar;
                    number += 2;
                } else {
                    temp[character] = aChar;
                    character += 2;
                }
            }
        }else {
            return "";
        }
        return String.valueOf(temp);
    }
}
