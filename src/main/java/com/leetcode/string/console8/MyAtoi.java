package com.leetcode.string.console8;

/**
 * 自动机
 * https://leetcode-cn.com/problems/string-to-integer-atoi/solution/zi-fu-chuan-zhuan-huan-zheng-shu-atoi-by-leetcode-/
 */
public class MyAtoi {
    public int myAtoi(String s) {
        //字符数组长度
        int length = s.length();
        //存答案
        long ans = 0;
        //存取正负：正为真，负为假
        boolean flag = true;
        //判断是否已经读取过数字或者正负号，没有为true，读取过为false
        boolean yes = true;
        for (int i = 0; i < length; i++) {
            //1.没读过数字和正负号，开头是空格就继续
            if (yes && s.charAt(i) == ' ') continue;
                //2.没读过数字和正负号，遇到正号，yes变为false
            else if (yes && ans == 0 && s.charAt(i) == '+') yes = false;
                //3.没读过数字和正负号，遇到负号，yes和flag均变为false
            else if (yes && ans == 0 && s.charAt(i) == '-') yes = flag = false;
                //4.遇到非数字了，也不是上面三种情况，返回ans或者-ans（flag决定的）
            else if (s.charAt(i) < '0' || s.charAt(i) > '9') return flag ? (int) ans : (int) -ans;
                //5.其他（读取到的数字）,yes变为false且ans更新
            else {
                yes = false;
                ans = ans * 10 + s.charAt(i) - '0';
            }

            //现在的ans已经( ans > int的上界 或 -ans <= int的下界)越界就直接返回
            if (ans > Integer.MAX_VALUE)
                return flag ? (int) Math.min((long) Integer.MAX_VALUE, ans) : (int) Math.max((long) Integer.MIN_VALUE, -ans);
        }
        //字符判断一遍也没越界，返回ans或者-ans（flag决定的）
        return flag ? (int) ans : (int) -ans;
    }

    /**
     * 模拟
     * 时间复杂度：O(n)
     * @param s
     * @return
     */
    public int myAtoi2(String s) {
        long ans = 0;
        s = s.trim();
        boolean plus = true;
        char[] chars = s.toCharArray();
        int i = 0;
        // 空串
        if (chars.length<1){
            return 0;
        }
        // 检查第一位
        if (chars[i] == '-') {
            plus = false;
            i++;
        }else if (chars[i]=='+'){
            i++;
        }

        //判断后续
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {    //如果是数字则记录进答案
            ans = ans * 10 + s.charAt(i++) - '0';
            if (ans > Integer.MAX_VALUE || (!plus && -ans < Integer.MIN_VALUE))
                break;
        }
        ans = plus ? ans : -1 * ans;
        if (ans > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (ans < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(new MyAtoi().myAtoi2("-2.2"));
    }
}
