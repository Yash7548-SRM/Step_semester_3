package week11.class_problems;

public class DeleteLastNodeDoubly {

    static class DNode {
        int data;
        DNode prev;
        DNode next;

        DNode(int data) {
            this.data = data;
        }
    }

    static DNode deleteLastNodeDoubly(DNode head) {
        if (head == null) return null;
        if (head.next == null) return null;
        DNode last = head;
        while (last.next != null) last = last.next;
        last.prev.next = null;
        last.prev = null;
        return head;
    }

    static DNode build(int[] values) {
        DNode head = null, tail = null;
        for (int v : values) {
            DNode node = new DNode(v);
            if (head == null) head = node;
            else {
                tail.next = node;
                node.prev = tail;
            }
            tail = node;
        }
        return head;
    }

    static void print(DNode head) {
        if (head == null) {
            System.out.println("(empty list)");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (DNode cur = head; cur != null; cur = cur.next) {
            sb.append(cur.data);
            if (cur.next != null) sb.append(" <-> ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        print(deleteLastNodeDoubly(build(new int[]{1, 2, 3})));
        print(deleteLastNodeDoubly(build(new int[]{5})));
    }
}