package com.leetcode.tree.interview0403;

import com.leetcode.link.ListNode;
import com.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ListOfDepth {
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree==null){
            return null;
        }
        List<ListNode> res=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()){
            int size=queue.size();
            ListNode dummyNode=new ListNode(-1);
            ListNode head=dummyNode;
            while (size-->0){
                TreeNode node=queue.poll();
                head.next=new ListNode(node.val);
                head=head.next;
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            res.add(dummyNode.next);
        }
        return res.toArray(new ListNode[res.size()]);
    }

//    public int getDepth(TreeNode treeNode){
//        if (treeNode==null){
//            return 0;
//        }
//        return Math.max(getDepth(treeNode.left),getDepth(treeNode.right))+1;
//    }
}
