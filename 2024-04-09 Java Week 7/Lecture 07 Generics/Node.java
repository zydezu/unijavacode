package tools;

public class Node {
    Integer data;
    Node next;

    Node(Integer data){
        this.data = data;
        this.next = null;
    }

    Node(Integer data, Node tail){
        this.data = data;
        this.next = tail;
    }
}