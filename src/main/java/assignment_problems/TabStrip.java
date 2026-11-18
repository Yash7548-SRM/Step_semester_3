import java.util.*;

public class TabStrip {
    static class Node {
        String name;
        Node prev, next;
        Node(String n) { name = n; }
    }

    Node head, tail, cur;

    String strip() {
        if (head == null) return "(empty)";
        StringBuilder sb = new StringBuilder();
        for (Node n = head; n != null; n = n.next) {
            if (n != head) sb.append(" <-> ");
            sb.append(n == cur ? "[" + n.name + "]" : n.name);
        }
        return sb.toString();
    }

    void open(String name) {
        Node n = new Node(name);
        if (cur == null) head = tail = n;
        else {
            n.prev = cur;
            n.next = cur.next;
            if (cur.next != null) cur.next.prev = n;
            else tail = n;
            cur.next = n;
        }
        cur = n;
        System.out.println("OPEN " + name + ": " + strip());
    }

    void close() {
        if (cur == null) { System.out.println("CLOSE: no tabs"); return; }
        Node gone = cur;
        if (gone.prev != null) gone.prev.next = gone.next;
        else head = gone.next;
        if (gone.next != null) gone.next.prev = gone.prev;
        else tail = gone.prev;
        cur = gone.next != null ? gone.next : gone.prev;
        System.out.println("CLOSE " + gone.name + ": " + strip());
    }

    void back() {
        if (cur == null || cur.prev == null) { System.out.println("BACK: already at first tab"); return; }
        cur = cur.prev;
        System.out.println("BACK: " + strip());
    }

    void forward() {
        if (cur == null || cur.next == null) { System.out.println("FORWARD: already at last tab"); return; }
        cur = cur.next;
        System.out.println("FORWARD: " + strip());
    }

    void printBackward() {
        StringBuilder sb = new StringBuilder();
        for (Node n = tail; n != null; n = n.prev) {
            if (n != tail) sb.append(" <-> ");
            sb.append(n.name);
        }
        System.out.println("Backward: " + sb);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TabStrip t = new TabStrip();
        while (sc.hasNext()) {
            String c = sc.next();
            if (c.equals("OPEN")) t.open(sc.next());
            else if (c.equals("CLOSE")) t.close();
            else if (c.equals("BACK")) t.back();
            else if (c.equals("FORWARD")) t.forward();
            else { sc.next(); t.printBackward(); }
        }
    }
}