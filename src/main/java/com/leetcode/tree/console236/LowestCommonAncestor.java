package com.leetcode.tree.console236;

import com.leetcode.tree.TreeNode;

/**
 * p 和 qq 在 rootroot 的子树中，且分列 rootroot 的 异侧（即分别在左、右子树中）；
 * p = rootp=root ，且 qq 在 rootroot 的左或右子树中；
 * q = rootq=root ，且 pp 在 rootroot 的左或右子树中；
 *
 * 作者：jyd
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-hou-xu/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LowestCommonAncestor {
    /**
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if (left!=null&&right!=null){
            return root;
        }
        else if (left!=null){
            return left;
        }
        return right;
    }
}
