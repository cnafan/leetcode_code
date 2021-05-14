package com.leetcode.string.console929;

import java.util.HashSet;
import java.util.Set;

public class NumUniqueEmails {
    public int numUniqueEmails(String[] emails) {
        Set<String> set=new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            String deal=getRealEmail(emails[i]);
            System.out.println(deal);
            set.add(deal);
        }
        return set.size();
    }

    public String getRealEmail(String s){
        String[] split = s.split("@");
        return dealName(split[0]).concat("@").concat(split[1]);
    }

    public String dealName(String name){
        int indexAdd=name.indexOf('+');
        if (indexAdd==-1){
            indexAdd=name.length();
        }
        return name.substring(0, indexAdd).replace(".", "");
    }

//    public  String dealAddress(String addr){
//
//    }


    public static void main(String[] args) {
        System.out.println(new NumUniqueEmails().numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.email.leet+alex@code.com"}));
    }
}
