package me.warren.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        if(root != null) {
            stack.push(root);
        }
        TreeNode cur = null;
        while(!stack.isEmpty()) {
            cur = stack.pop();
            result.add(cur.val);
            if(cur != null) {
                if(cur.right != null) {
                    stack.push(cur.right);
                }
                if(cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode[] nodes = new TreeNode[7];

        for (int i = 0; i < 7; i++) {
            nodes[i] = new TreeNode(i);
        }

        for (int i = 0; i < 7; i++) {
            if (i < 3) {
                nodes[i].left = nodes[2 * i + 1];
                nodes[i].right = nodes[2 * i + 2];
            } else {
                nodes[i].left = null;
                nodes[i].right = null;
            }
        }

        Solution144 solution = new Solution144();
        List<Integer> result = solution.preorderTraversal(nodes[0]);
        for (Integer num : result) {
            System.out.print(num);
            System.out.print(' ');
        }
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}