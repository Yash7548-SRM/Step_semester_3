package week11.class_problems;

public class InsertAtEndCircular {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node insertAtEndCircular(Node head, int value) {
        Node newNode = new Node(value);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        Node last = head;
        while (last.next != head) last = last.next;
        last.next = newNode;
        newNode.next = head;
        return head;
    }

    static void print(Node head) {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        do {
            sb.append(current.data).append(" -> ");
            current = current.next;
        } while (current != head);
        sb.append("(back to ").append(head.data).append(")");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        Node head = null;
        head = insertAtEndCircular(head, 1);
        head = insertAtEndCircular(head, 2);
        head = insertAtEndCircular(head, 3);
        head = insertAtEndCircular(head, 4);
        print(head);

        print(insertAtEndCircular(null, 9));
    }
}