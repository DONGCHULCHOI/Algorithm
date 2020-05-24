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

    public void inOrderTraversal(TreeNode node){
        if(node == null){
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.val + " "); // visit(node)
        inOrderTraversal(node.right);
    }

    public void preOrderTraversal(TreeNode node){
        if(node == null){
            return;
        }
        System.out.print(node.val + " "); // visit(node)
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public void postOrderTraversal(TreeNode node){
        if(node == null){
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.val + " "); // visit(node)
    }
    
    public int maxDepth(TreeNode node){ // == height
        if(node == null){
            return 0;
        }
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }
}
