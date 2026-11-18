import java.util.*;

public class MergeWaitlists {
    static class Node {
        int data;
        Node next;
        Node(int d) { data = d; }
    }

    static Node merge(Node a, Node b) {
        Node dummy = new Node(0), tail = dummy;
        while (a != null && b != null) {
            if (a.data <= b.data) { tail.next = a; a = a.next; }
            else { tail.next = b; b = b.next; }
            tail = tail.next;
        }
        tail.next = a != null ? a : b;
        return dummy.next;
    }

    static Node build(String line) {
        Node head = null, tail = null;
        for (String s : line.trim().split("\\s+")) {
            if (s.isEmpty()) continue;
            Node n = new Node(Integer.parseInt(s));
            if (head == null) head = tail = n;
            else tail = tail.next = n;
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node a = build(sc.hasNextLine() ? sc.nextLine() : "");
        Node b = build(sc.hasNextLine() ? sc.nextLine() : "");
        StringBuilder sb = new StringBuilder();
        for (Node n = merge(a, b); n != null; n = n.next) sb.append(n.data).append(" -> ");
        System.out.println(sb.append("null"));
    }
}