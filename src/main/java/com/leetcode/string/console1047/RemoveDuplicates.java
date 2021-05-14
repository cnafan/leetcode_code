package com.leetcode.string.console1047;

import java.util.Arrays;
import java.util.Stack;

/**
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *  
 */
public class RemoveDuplicates {
    public String removeDuplicates(String S) {
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (stack.isEmpty()){
                stack.push(S.charAt(i));
            }
            else if(stack.peek()==S.charAt(i)){
                stack.pop();
            }else {
                stack.push(S.charAt(i));
            }
        }
        char[] s=new char[stack.size()];
        for (int j=stack.size()-1;j>=0;j--){
            s[j]=stack.pop();
        }
       return new String(s);
    }


    public static void main(String[] args) {
        System.out.println(new RemoveDuplicates().removeDuplicates("abbaca"));
    }
}
