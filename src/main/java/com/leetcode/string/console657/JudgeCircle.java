package com.leetcode.string.console657;

public class JudgeCircle {
    public boolean judgeCircle(String moves) {
        int x=0,y=0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i)=='R'){
                x++;
            }else if (moves.charAt(i)=='L'){
                x--;
            }else if (moves.charAt(i)=='U'){
                y++;
            }else{
                y--;
            }
        }
        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        System.out.println(new JudgeCircle().judgeCircle("LL"));
    }
}
