package week10.assigment_problems;

public class TrainCoachesBothWays {

    static class Node {
        String name;
        Node prev;
        Node next;

        Node(String name) {
            this.name = name;
        }
    }

    static class Train {
        Node head;
        Node tail;

        void addLast(String name) {
            Node node = new Node(name);
            if (head == null) {
                head = tail = node;
                return;
            }
            node.prev = tail;
            tail.next = node;
            tail = node;
        }

        void remove(String name) {
            Node cur = head;
            while (cur != null && !cur.name.equals(name)) cur = cur.next;
            if (cur == null) return;

            if (cur.prev != null) cur.prev.next = cur.next;
            else head = cur.next;

            if (cur.next != null) cur.next.prev = cur.prev;
            else tail = cur.prev;
        }

        void printForward() {
            StringBuilder sb = new StringBuilder("Forward: ");
            for (Node cur = head; cur != null; cur = cur.next) {
                sb.append(cur.name);
                if (cur.next != null) sb.append(" <-> ");
            }
            System.out.println(sb);
        }

        void printBackward() {
            StringBuilder sb = new StringBuilder("Backward: ");
            for (Node cur = tail; cur != null; cur = cur.prev) {
                sb.append(cur.name);
                if (cur.prev != null) sb.append(" <-> ");
            }
            System.out.println(sb);
        }
    }

    public static void main(String[] args) {
        Train train = new Train();
        String[] coaches = {"Engine", "A1", "B1", "B2", "Guard"};
        for (String c : coaches) train.addLast(c);

        train.remove("B1");
        train.printForward();
        train.printBackward();
    }
}