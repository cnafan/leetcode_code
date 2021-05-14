package com.leetcode.string.console937;

import java.util.Arrays;

public class ReorderLogFiles {
    /**
     * 自定义排序
     * @param logs
     * @return
     *
     * string.split(" ",2) 用空格将字符串分割为两部分
     * Character.isDigit() 判断字符串是否为数字
     * string.compareTo(string) 比较两个字符串
     */
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs,(log1,log2)->{
            String[] split1=log1.split(" ",2);
            String[] split2=log2.split(" ",2);
            // 确定是否为数字
            boolean isDigit1= Character.isDigit(split1[1].charAt(0));
            boolean isDigit2= Character.isDigit(split2[1].charAt(0));

            // 若都为字母，比较后半部分，内容相同比较前半部分
            if (!isDigit1&&!isDigit2){
                int cmp=split1[1].compareTo(split2[1]);
                if (cmp!=0){
                    return cmp;
                }else {
                    return split1[0].compareTo(split2[0]);
                }
            }

            // 若1为数字 2为字母
            // 若1为数字 2为数字
            // 若1为字母 2为数字
            return isDigit1 ? (isDigit2?0:1):-1;
        });
        return logs;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ReorderLogFiles().reorderLogFiles(new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"})));
    }

}
