package week10.assigment_problems;

public class PriorityTokenInsertion {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static class TokenList {
        Node head;

        void addFirst(int token) {
            Node node = new Node(token);
            node.next = head;
            head = node;
        }

        void addLast(int token) {
            Node node = new Node(token);
            if (head == null) {
                head = node;
                return;
            }
            Node cur = head;
            while (cur.next != null) cur = cur.next;
            cur.next = node;
        }

        void insertAt(int index, int token) {
            if (index == 0) {
                addFirst(token);
                return;
            }
            Node prev = head;
            for (int i = 0; i < index - 1; i++) prev = prev.next;
            Node node = new Node(token);
            node.next = prev.next;
            prev.next = node;
        }

        void print() {
            StringBuilder sb = new StringBuilder();
            for (Node cur = head; cur != null; cur = cur.next) {
                sb.append(cur.data).append(" -> ");
            }
            sb.append("null");
            System.out.println(sb);
        }
    }

    public static void main(String[] args) {
        TokenList list = new TokenList();
        list.addLast(101);
        list.addLast(102);
        list.addLast(103);

        list.addFirst(100);
        list.addLast(104);
        list.insertAt(2, 150);

        list.print();
    }
}