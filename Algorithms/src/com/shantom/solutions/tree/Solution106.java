package com.shantom.solutions.tree;

import com.shantom.structures.tree.TreeNode;

public class Solution106 {
    private int[] inorder;
    private int[] postorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;

        return build(0, inorder.length, 0, postorder.length);
    }

    private TreeNode build(int inStart, int inEnd, int postStart, int postEnd){
        if(inStart>=inEnd){
            return null;
        }
        int rootVal = postorder[postEnd-1];
        TreeNode root = new TreeNode(rootVal);

        int i = indexOf(inorder, inStart, inEnd, rootVal);
        int m = postEnd - (inEnd - i - 1) - 1;

        root.left = build(inStart, i, postStart, m);
        root.right = build(i+1, inEnd, m, postEnd-1);
        return root;
    }

    private int indexOf(int[] nums, int start, int end, int target){
        for (int i = start; i < end; i++) {
            if(nums[i] == target){
                return i;
            }
        }
        return -1;
    }
}
