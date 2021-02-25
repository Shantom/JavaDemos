package com.shantom.solutions.tree;

import com.shantom.structures.tree.TreeNode;
import com.shantom.structures.tree.TreeUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution652 {
    public static void main(String[] args) throws TreeUtils.WrongTreeStructure {
        TreeNode root = TreeUtils.constructTree(new Integer[]{1, 2, 3, 4, null, 2, 4, null, null, 4});
        List<TreeNode> res = new Solution652().findDuplicateSubtrees(root);
    }

    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    private String traverse(TreeNode root){
        if(root==null){
            return "#";
        }

        String left = traverse(root.left);
        String right = traverse(root.right);
        String str = left+","+right+":"+root.val;
        if(map.getOrDefault(str, 0)==1){
            res.add(root);
        }
        map.put(str, map.getOrDefault(str, 0) + 1);

        return str;
    }
}
