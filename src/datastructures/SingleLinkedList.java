package datastructures;

import java.util.ArrayList;
import java.util.List;

public class SingleLinkedList {

    Node head;

    public String toString() {
        Node currNode = head;
        List<Integer> res = new ArrayList<>();
        while (currNode != null) {
            res.add(currNode.data);
            currNode = currNode.next;
        }
        return res.toString();
    }

    // O(1)
    public Node addNode(int data) {
        if (head == null) {
            head = new Node(data, null);
        } else {
            head = new Node(data, head);
        }
        return head;
    }


    public Node deleteNode(Node node) {
        Node current = head;
        boolean deleted = false;
        while (current != null && !deleted) {
            if (current.next.equals(node)) {
                current.next = current.next.next;
                deleted = true;
            }
            current = current.next;
        }
        return head;
    }

    // O(N), assuming unique data set
    public Node getNode(int data) {
        Node current = head;
        while (current != null && current.data != data) {
            current = current.next;
        }
        return current.data == data ? current : null;
    }

    public static class Node {

        int data = 0;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    static void main() {
        SingleLinkedList list = new SingleLinkedList();
        list.addNode(10);
        list.addNode(20);
        list.addNode(30);
        Node getNode = list.getNode(20);
        list.deleteNode(getNode);
        System.out.println(list);
    }
}
