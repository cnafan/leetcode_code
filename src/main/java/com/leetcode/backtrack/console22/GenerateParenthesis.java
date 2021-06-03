package com.leetcode.backtrack.console22;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 回溯
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        backtrace(res,new StringBuilder(),n*2);
        return res;

    }
    public void backtrace(List<String> res,StringBuilder temp,int target){
        if (target < 0) {
            return;
        }
        if (target==0){
            String s = new String(temp);
            if (isValid(s)) {
                res.add(s);
            }
            return;
        }

        temp.append('(');
        backtrace(res,temp,target-1);
        temp.deleteCharAt(temp.length()-1);

        temp.append(')');
        backtrace(res,temp,target-1);
        temp.deleteCharAt(temp.length()-1);
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch=='('){
                stack.push(ch);
            }else if (ch== ')'&&!stack.isEmpty()){
                if (stack.peek()=='('){
                    stack.pop();
                }
                else {
                    return false;
                }
            }else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(1));

//        String[] s=new String[]{"((()))","(()()","(())()","()(())","()()()"};
//        for(String str:s){
//            System.out.println(new GenerateParenthesis().isValid(str));
//        }
    }
}
