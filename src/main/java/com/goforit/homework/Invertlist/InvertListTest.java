package com.goforit.homework.Invertlist;

/**
 * Created by junqingfjq on 16/5/28.
 */
public class InvertListTest {

    public static void main(String [] argvs){

        Node head=new Node("1",new Node("2",new Node("3",new Node("4",new Node("5",null)))));

        Node p=head;
        while(p!=null){
            System.err.println(p.value);
            p=p.pNext;
        }

        System.err.println("=====invert=====");

        Node newHead=invertList(head);
        head.pNext=null;
        p=newHead;
        while(p!=null){
            System.err.println(p.value);
            p=p.pNext;
        }

    }

    static class Node{

        public Node(){

        }

        public Node(String value,Node next){
            this.value=value;
            this.pNext=next;
        }

        public String value;

        public Node pNext;
    }

    public static Node invertList(Node node){

        Node result=null;
        if(null!=node.pNext.pNext){
            result=invertList(node.pNext);
            node.pNext.pNext=node;
        }else {
            node.pNext.pNext=node;
            result=node.pNext;
        }

        return result;

    }
}
