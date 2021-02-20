package com.shantom.solutions.tree;

import com.shantom.structures.tree.TreeNode;
import com.shantom.structures.tree.TreeUtils;

public class Solution114 {
    public static void main(String[] args) throws TreeUtils.WrongTreeStructure {
        TreeNode root = TreeUtils.constructTree(new Integer[]{1, 2, 5, 3, 4, null, 6});
        new Solution114().flatten(root);
        System.out.println("hello");
    }

    public void flatten(TreeNode root) {
        traverse(root);
    }

    private TreeNode traverse(TreeNode root){
        if(root.left == null && root.right == null){
            return root;
        }else if(root.left == null){
            return traverse(root.right);
        }else if(root.right == null){
            root.right = root.left;
            root.left = null;
            return traverse(root.right);
        }else{
            TreeNode right = root.right;
            TreeNode leftTail = traverse(root.left);
            root.right = root.left;
            leftTail.right = right;
            root.left = null;
            return traverse(right);
        }
    }

}
