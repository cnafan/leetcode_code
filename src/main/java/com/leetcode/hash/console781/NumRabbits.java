package com.leetcode.hash.console781;

/**
 * 核心点：
 *      1.若一个兔子说有n只其他的兔子颜色一样，则该颜色的兔子有n+1只
 *      2.所以只需统计每个颜色的第一只兔子所说的话，同一个颜色的其他兔子说的都可以算作无效数据进行跳过
 * https://leetcode-cn.com/problems/rabbits-in-forest/solution/java-mo-ni-xiang-xi-zhu-shi-by-lippon-61wd/
 * @author : cnafan
 * @date : 2021-08-22 09:34
 **/
public class NumRabbits {
    public int numRabbits(int[] answers) {
        int[] hash=new int[1000];
        int res=0;
        for (int i:answers){
            if (hash[i]>0){
                // 为了保证 {1 1 1} 这种情况最少有4只兔子的情况，所以不能直接跳过，需要精确过滤掉多余的，保证第三次出现的1为有效值
                hash[i]--;

            }else {
                hash[i]=i;
                res+=i+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new NumRabbits().numRabbits(new int[]{1, 1, 2}));
    }
}
