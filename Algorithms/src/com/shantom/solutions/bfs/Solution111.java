package com.shantom.solutions.bfs;

import com.shantom.structures.tree.TreeNode;
import com.shantom.structures.tree.TreeUtils;

import java.util.*;

public class Solution111 {
    public static void main(String[] args) throws TreeUtils.WrongTreeStructure {
        TreeNode root = TreeUtils.constructTree(new Integer[]{3, 9,20,null,null,15,7});
        int res = new Solution111().minDepth(root);
        System.out.println(res);

    }

    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int deepth = 1;

        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if(cur.left==null&&cur.right==null){
                    return deepth;
                }
                if(cur.left!=null) {
                    queue.add(cur.left);
                }
                if(cur.right!=null) {
                    queue.add(cur.right);
                }
            }
            deepth++;
        }
        return deepth;
    }
}
