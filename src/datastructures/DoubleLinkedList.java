package datastructures;

public class DoubleLinkedList {


    Node head;
    Node tail;

    // O(1) Add to head of list
    public Node addNode(int data) {
        if (head == null & tail == null) {
            Node firstNode = new Node(data, null, null);
            head = firstNode; tail = firstNode;
        } else {
            head = new Node(data, null, head);
        }
        return head;
    }

    // O(N)
    public Node insertAtPosition(int index, int data) {
        if (index <= 0) {
            addNode(data);
        }
        Node currNode = head;
        while (currNode != null && index < 1) {
            currNode = currNode.next;
            index--;
        }
        if (currNode == null) {
            // Return unmodded list
            return head;
        }
        Node newNode = new Node(data, currNode, currNode.next);
        currNode.next = newNode;
        currNode.next.prev = newNode;

        return head;
    }

    public static class Node {

        int data;
        Node prev;
        Node next;

        Node(int data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
}
