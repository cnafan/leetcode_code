package com.leetcode.string.console1507;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReformatDate {

    // 可以用字典直接映射加快速度
    // 格式化输出可以使用 string.format("%d-%2d-%2d",year,month,day)+

    public String reformatDate(String date) {
        String[] months = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] datas = date.split(" ");

        int month = 0;
        int day = 0;
        for (int i = 0; i < months.length; i++) {
            if (months[i].equals(datas[1])) {
                month = i + 1;
                break;
            }
        }
        Pattern pattern = Pattern.compile("\\d{1,2}(?=.{2})");
        Matcher m = pattern.matcher(datas[0]);
        if (m.find()) {
            day = Integer.parseInt(m.group(0));
        }
        LocalDate d2 = LocalDate.of(Integer.parseInt(datas[2]), month, day);
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return d2.format(formatter);
    }

    public static void main(String[] args) {
        System.out.println(new ReformatDate().reformatDate("6th Jun 1933"));

    }
}
