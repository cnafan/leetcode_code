package com.offer.offer33;

/**
 * 对于后序序列，最后一位为根节点的值，在根节点的左侧存在一个序列，该序列所有元素都小于根节点，存在另外一个都大于根节点
 * <p>
 * 用反例排除
 */
public class VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        return dfs(postorder, 0, postorder.length-1);
    }

    // 取到end
    boolean dfs(int[] postorder, int start, int end) {
        if (start>=end) {
            return true;
        }
        // 找到mid:右子树的第一个
        // 错误！！！！ 不一定找到比它大的 所以初始值要设为end
        int mid = end;
        for (int i = start; i <= end; i++) {
            if (postorder[i] > postorder[end]) {
                mid = i;
                break;
            }
        }
        // 检查右半部分
        for (int i = mid; i < end; i++) {
            if (postorder[i] < postorder[end]) {
                return false;
            }
        }
        boolean left = dfs(postorder, start, mid-1);
        boolean right = dfs(postorder, mid, end-1);
        return left && right;
    }

    public static void main(String[] args) {

        System.out.println(new VerifyPostorder().verifyPostorder(new int[]{4,6,7,5}));
//        System.out.println(new VerifyPostorder().verifyPostorder(new int[]{5, 7, 6, 9, 11, 10, 8}));
    }
}
