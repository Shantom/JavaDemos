package com.shantom.solutions.tree;

import com.shantom.structures.tree.TreeNode;

public class Solution105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd,
                   int[] inorder, int inStart, int inEnd) {
        if(preStart>=preEnd){
            return null;
        }

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int i = indexOf(inorder, inStart, inEnd, rootVal);
        int m = preStart + (i - inStart) + 1;

        root.left = build(preorder, preStart+1, m, inorder, inStart, i);
        root.right = build(preorder, m, preEnd, inorder, i+1, inEnd);
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
