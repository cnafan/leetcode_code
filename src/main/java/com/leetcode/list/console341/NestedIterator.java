package com.leetcode.list.console341;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {

    Iterator<Integer> cur;

    public NestedIterator(List<NestedInteger> nestedList) {
        List<Integer> result = new ArrayList<>();
        dfs(nestedList,result);
        cur=result.listIterator();//********
    }

    @Override
    public Integer next() {
       return cur.next();
    }

    @Override
    public boolean hasNext() {
        return cur.hasNext();
    }

    public void dfs(List<NestedInteger> nestedList, List<Integer> result){
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                result.add(nestedInteger.getInteger());
            } else {
                dfs(nestedInteger.getList(), result);
            }
        }
    }
}
