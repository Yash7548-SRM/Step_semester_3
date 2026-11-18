import java.util.*;

public class Counselling {
    static class Node {
        int data;
        Node next;
        Node(int d) { data = d; }
    }

    static Node partition(Node head, int passMark) {
        Node lowDummy = new Node(0), highDummy = new Node(0);
        Node low = lowDummy, high = highDummy;
        for (Node n = head; n != null; n = n.next) {
            if (n.data < passMark) low = low.next = n;
            else high = high.next = n;
        }
        high.next = null;
        low.next = highDummy.next;
        return lowDummy.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null, tail = null;
        for (String s : sc.nextLine().trim().split("\\s+")) {
            if (s.isEmpty()) continue;
            Node n = new Node(Integer.parseInt(s));
            if (head == null) head = tail = n;
            else tail = tail.next = n;
        }
        StringBuilder sb = new StringBuilder();
        for (Node n = partition(head, sc.nextInt()); n != null; n = n.next) sb.append(n.data).append(" -> ");
        System.out.println(sb.append("null"));
    }
}