package week10.assigment_problems;

public class CancelledOrdersCleanup {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node removeAll(Node head, int code) {
        while (head != null && head.data == code) {
            head = head.next;
        }
        Node prev = head;
        while (prev != null && prev.next != null) {
            if (prev.next.data == code) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;
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
            sb.append(cur.data).append(" -> ");
        }
        sb.append("null");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        print(removeAll(build(new int[]{5, 3, 5, 8, 5}), 5));
        print(removeAll(build(new int[]{5, 5, 5}), 5));
    }
}