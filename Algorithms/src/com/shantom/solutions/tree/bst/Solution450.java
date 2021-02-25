package com.shantom.solutions.tree.bst;

import com.shantom.structures.tree.TreeNode;
import com.shantom.structures.tree.TreeUtils;

public class Solution450 {
    public static void main(String[] args) throws TreeUtils.WrongTreeStructure {
        TreeNode root = TreeUtils.constructTree(new Integer[]{5, 3, 6, 2, 4, null, 7});
        TreeNode res = new Solution450().deleteNode(root, 3);
        System.out.println(res);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(root.val == key){
            if(root.left==null){
                return root.right;
            }
            if(root.right==null){
                return root.left;
            }
            TreeNode node = getMin(root.right);
            root.val = node.val;
            root.right = deleteNode(root.right, node.val);
        }else if(key<root.val){
            root.left = deleteNode(root.left, key);
        }else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private TreeNode getMin(TreeNode root){
        TreeNode res = root;
        while(root.left!=null){
            root = root.left;
            res = root;
        }
        return res;
    }
}
