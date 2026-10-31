package week11.class_problems;

public class SplitListInHalf {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node splitListInHalf(Node head) {
        if (head == null) return null;
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node second = slow.next;
        slow.next = null;
        return second;
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

    static String toText(Node head) {
        if (head == null) return "(empty)";
        StringBuilder sb = new StringBuilder();
        for (Node cur = head; cur != null; cur = cur.next) {
            sb.append(cur.data);
            if (cur.next != null) sb.append(" -> ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Node first = build(new int[]{1, 2, 3, 4, 5});
        Node second = splitListInHalf(first);
        System.out.println("First half: " + toText(first) + " Returned: " + toText(second));

        first = build(new int[]{1, 2, 3, 4});
        second = splitListInHalf(first);
        System.out.println("First half: " + toText(first) + " Returned: " + toText(second));
    }
}