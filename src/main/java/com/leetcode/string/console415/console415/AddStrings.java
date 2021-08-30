package com.leetcode.string.console415.console415;

/**
 * 保存进位
 * 如果进位还有则继续计算
 *
 * @author : cnafan
 * @date : 2021-08-27 14:08
 **/

public class AddStrings {

    public String addStrings(String num1, String num2) {
        int add = 0;
        StringBuilder stringBuilder = new StringBuilder();
        int p1 = num1.length() - 1, p2 = num2.length() - 1;
        while ((p1 >= 0 && p2 >= 0) || add == 1) {
            int n1 = p1 < 0 ? 0 : num1.charAt(p1) - '0';
            int n2 = p2 < 0 ? 0 : num2.charAt(p2) - '0';
            int sum = n1 + n2 + add;
            add = sum / 10;
            stringBuilder.append(sum % 10);
            if (p1 >= 0)
                p1--;
            if (p2 >= 0)
                p2--;
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new AddStrings().addStrings("933", "222"));
    }
}
