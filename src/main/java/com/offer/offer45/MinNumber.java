package com.offer.offer45;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 考察自定义排序
 *
 * 对于任意两个字符串，若mn>nm，则说明m>n
 */
public class MinNumber {
    public String minNumber(int[] nums) {
        List<String> str_nums = Arrays.stream(nums).boxed().collect(Collectors.toList()).stream().map(Object::toString).collect(Collectors.toList());

        str_nums.sort((o1, o2) -> (o1+o2).compareTo(o2+o1));

        StringBuilder stringBuilder=new StringBuilder();
        for (String str:str_nums){
            stringBuilder.append(str);
        }
        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        System.out.println(new MinNumber().minNumber(new int[]{3,30,34,5,9}));
    }
}
