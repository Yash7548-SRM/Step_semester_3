import java.util.*;

public class LastButK {
    static class Node {
        int data;
        Node next;
        Node(int d) { data = d; }
    }

    static String kthFromEnd(Node head, int k) {
        Node lead = head, trail = head;
        for (int i = 0; i < k; i++) {
            if (lead == null) return "Invalid k";
            lead = lead.next;
        }
        while (lead != null) {
            lead = lead.next;
            trail = trail.next;
        }
        return k + " from the end: " + trail.data;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null, tail = null;
        for (String s : sc.nextLine().trim().split("\\s+")) {
            Node n = new Node(Integer.parseInt(s));
            if (head == null) head = tail = n;
            else tail = tail.next = n;
        }
        System.out.println(kthFromEnd(head, sc.nextInt()));
    }
}