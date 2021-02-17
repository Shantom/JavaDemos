package com.shantom.solutions;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtils {
    public static void main(String[] args) {
        Integer[] nums = {3,9};
        try {
            TreeNode root = TreeUtils.constructTree(nums);
            System.out.println(root);
        } catch (WrongTreeStructure wrongTreeStructure) {
            wrongTreeStructure.printStackTrace();
        }
    }

    public static TreeNode constructTree(Integer[] nums) throws WrongTreeStructure {
        if(nums.length<1){
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(nums[0]);
        queue.add(root);
        TreeNode parent = null;
        int mark = 2;
        for (int i = 1; i< nums.length; i++) {
            if(mark==2){
                mark = 0;
                parent = queue.poll();
                if(parent==null){
                    throw new WrongTreeStructure();
                }
            }
            TreeNode cur;
            if(nums[i]==null){
                cur = null;
            }else {
                cur = new TreeNode(nums[i]);
                queue.add(cur);
            }
            if(mark==0){
                mark=1;
                parent.left = cur;
            }else if(mark==1){
                mark = 2;
                parent.right = cur;
            }
        }
        return root;
    }

    public static class WrongTreeStructure extends Exception{

    }
}
