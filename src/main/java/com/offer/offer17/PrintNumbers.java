package com.offer.offer17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintNumbers {
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    List<String> res;
    int[] ret;
    int index_ret;
    public int[] printNumbers(int n) {
        index_ret=0;
        ret=new int[(int)Math.pow(10,n)-1];
        num = new char[n];
        res = new ArrayList<>();
        //按位数循环调用，先打印一位数，再打印两位数，直到打印n位数
        for (int i = 0; i < n; i++) {
            dfs(0, i + 1);
        }

        return ret;
    }

    void dfs(int index, int n) {
        // 递归终止条件
        // 打印到最后一位，中止递归
        if (index >= n) {
//            res.add(String.valueOf(num));
            ret[index_ret++]=Integer.parseInt(new String(num).substring(0,index));
            return;
        }
        // 过滤掉首位为0的
        int start = 0;
        if (index == 0) {
            start = 1;
        }
        for (int i = start; i < 10; i++) {
            num[index] = loop[i];
            dfs(index + 1, n);
            ;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PrintNumbers().printNumbers(4)));
    }

}
