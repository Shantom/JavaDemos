package com.shantom.solutions.tree;

import com.shantom.structures.tree.TreeNode;
import com.shantom.structures.tree.TreeUtils;

public class Solution236 {
    public static void main(String[] args) throws TreeUtils.WrongTreeStructure {
        TreeNode root = TreeUtils.constructTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(4);

        TreeNode res = new Solution236().lowestCommonAncestor(root, p, q);
        System.out.println(res);
    }

    private TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traverse(root, p, q);
        return res;
    }

    private int traverse(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return 0;
        }
        int count = 0;
        if(root.val==p.val || root.val==q.val){
            count++;
        }
        // 有结果了
        if(res != null){
            return 0;
        }
        count += traverse(root.left, p, q);
        if(res != null){
            return 0;
        }
        count += traverse(root.right, p, q);
        if(count==2 && res==null){
            res = root;
        }
        return count;
    }

}
