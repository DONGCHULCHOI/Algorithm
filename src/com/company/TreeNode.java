package com.company;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void inOrderTraversal(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        inOrderTraversal(treeNode.left);
        System.out.print(treeNode.val + " "); // visit(node)
        inOrderTraversal(treeNode.right);
    }

    public void preOrderTraversal(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        System.out.print(treeNode.val + " "); // visit(node)
        preOrderTraversal(treeNode.left);
        preOrderTraversal(treeNode.right);
    }

    public void postOrderTraversal(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        postOrderTraversal(treeNode.left);
        postOrderTraversal(treeNode.right);
        System.out.print(treeNode.val + " "); // visit(node)
    }
}
