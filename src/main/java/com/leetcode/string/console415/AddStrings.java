package com.leetcode.string.console415;

public class AddStrings {
    /**
     * 模拟进位，用两个指针分别读取，考虑几个注意项
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int p1 = num1.length() - 1, p2 = num2.length() - 1;
        int add = 0;
        while ((p1 >= 0 || p2 >= 0)||add==1) {
            int n1 = p1 < 0 ? 0 : (num1.charAt(p1) - '0');
            int n2 = p2 < 0 ? 0 : (num2.charAt(p2) - '0');
            int sum = n1 + n2 + add;
            add = sum > 9 ? 1 : 0;
            sb.append(sum % 10);
            if (p1>=0){
                p1--;
            }
            if (p2>=0){
                p2--;
            }
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new AddStrings().addStrings("10", "9"));
    }
}
