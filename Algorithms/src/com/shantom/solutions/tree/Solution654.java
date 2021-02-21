package com.shantom.solutions.tree;

import com.shantom.structures.tree.TreeNode;

public class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }

    public TreeNode construct(int[] nums, int start, int end){
        if(start>=end){
            return null;
        }
        int m = indexOfMax(nums, start, end);
        TreeNode root = new TreeNode(nums[m]);
        root.left = construct(nums, start, m);
        root.right = construct(nums, m+1, end);
        return root;
    }

    private int indexOfMax(int[] nums, int start, int end){
        int max = 0;
        int res = start;
        for (int i = start; i < end; i++) {
            if(nums[i]>max){
                max = nums[i];
                res = i;
            }
        }
        return res;
    }
}
