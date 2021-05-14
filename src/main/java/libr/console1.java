package libr;

import sun.security.util.Length;

// 判断循环字符串右移几位
public class console1 {
    public int isCrossString(int len, String x, String y) {
        String xx = x + x;
//        int slow=0;
//        int fast=0;
//        int ret=0;
//        while (y.charAt(fast)!=xx.charAt(slow)){
//            slow++;
//            ret++;
//        }
//        boolean res=true;
//        while (fast < len) {
//            if (y.charAt(fast)==xx.charAt(slow)){
//                fast++;
//                slow++;
//            }else {
//                res=false;
//                break;
//            }
//        }
//        if (res)
//        return ret;
//        else {
//            return 0;
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new console1().isCrossString(4, "edd", "abc"));
    }
}
