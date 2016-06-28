package com.goforit.homework.tree;

import java.util.Stack;

/**
 * Created by junqingfjq on 16/5/22.
 */
public class TreeQueryTest {

    static class TreeNode{
        private int value;

        private TreeNode parentNode;

        private TreeNode leftNode;

        private TreeNode rightNode;

        public TreeNode(int value,TreeNode parent,TreeNode leftNode,TreeNode rightNode){
            this.value=value;
            this.parentNode=parent;
            this.leftNode=leftNode;
            this.rightNode=rightNode;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public TreeNode getParentNode() {
            return parentNode;
        }

        public void setParentNode(TreeNode parentNode) {
            this.parentNode = parentNode;
        }

        public TreeNode getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(TreeNode leftNode) {
            this.leftNode = leftNode;
        }

        public TreeNode getRightNode() {
            return rightNode;
        }

        public void setRightNode(TreeNode rightNode) {
            this.rightNode = rightNode;
        }
    }

    public static void main(String [] args){


        TreeNode t1=new TreeNode(10,null,null,null);

        TreeNode t2=new TreeNode(6,t1,null,null);
        TreeNode t3=new TreeNode(4,t2,null,null);
        TreeNode t4=new TreeNode(8,t2,null,null);
        t2.setLeftNode(t3);
        t2.setRightNode(t4);

        TreeNode t5=new TreeNode(14,t1,null,null);
        TreeNode t6=new TreeNode(12,t5,null,null);
        TreeNode t7=new TreeNode(16,t5,null,null);

        t5.setLeftNode(t6);
        t5.setRightNode(t7);

        t1.setLeftNode(t2);
        t1.setRightNode(t5);

//        firstQueryTree(t1);
//        middleQueryTree(t1);
//        afterQueryTree(t1);
        firstQueryTree2(t1);
    }

    public static void firstQueryTree(TreeNode head){

        TreeNode t=head;

        if(null==t){
            return;
        }

        System.err.println(t.getValue());

        firstQueryTree(t.getLeftNode());
        firstQueryTree(t.getRightNode());
    }

    public static void middleQueryTree(TreeNode head){

        TreeNode t=head;

        if(null==t){
            return;
        }

        middleQueryTree(t.getLeftNode());

        System.err.println(t.getValue());

        middleQueryTree(t.getRightNode());
    }

    public static void afterQueryTree(TreeNode head){

        TreeNode t=head;

        if(null==t){
            return;
        }

        afterQueryTree(t.getLeftNode());

        afterQueryTree(t.getRightNode());

        System.err.println(t.getValue());
    }

    public static void firstQueryTree2(TreeNode head){

        if(null==head){
            return ;
        }

        Stack<TreeNode> stack=new Stack<TreeNode>();
        stack.push(head);
        while (!stack.isEmpty()){
            TreeNode t=stack.pop();
            System.err.println(t.getValue());

            if(null!=t.getRightNode()){
                stack.push(t.getRightNode());
            }

            if(null!=t.getLeftNode()){
                stack.push(t.getLeftNode());
            }

        }
    }
}
