import java.util.*;

public class MiddleSeat {
    static class Node {
        int data;
        Node next;
        Node(int d) { data = d; }
    }

    static int middle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null, tail = null;
        while (sc.hasNextInt()) {
            Node n = new Node(sc.nextInt());
            if (head == null) head = tail = n;
            else tail = tail.next = n;
        }
        System.out.println("Middle: " + middle(head));
    }
}