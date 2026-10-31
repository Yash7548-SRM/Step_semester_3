package week11.class_problems;

public class ReverseFirstKNodes {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node reverseFirstKNodes(Node head, int k) {
        Node previous = null;
        Node current = head;
        for (int i = 0; i < k && current != null; i++) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head.next = current;
        return previous;
    }

    static Node build(int[] values) {
        Node head = null, tail = null;
        for (int v : values) {
            Node node = new Node(v);
            if (head == null) head = node;
            else tail.next = node;
            tail = node;
        }
        return head;
    }

    static void print(Node head) {
        StringBuilder sb = new StringBuilder();
        for (Node cur = head; cur != null; cur = cur.next) {
            sb.append(cur.data);
            if (cur.next != null) sb.append(" -> ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        print(reverseFirstKNodes(build(new int[]{1, 2, 3, 4, 5}), 3));
        print(reverseFirstKNodes(build(new int[]{1, 2, 3, 4, 5}), 5));
    }
}