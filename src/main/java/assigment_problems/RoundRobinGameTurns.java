package week10.assigment_problems;

public class RoundRobinGameTurns {

    static class Node {
        String name;
        Node next;

        Node(String name) {
            this.name = name;
        }
    }

    static class PlayerCircle {
        Node tail;

        void addLast(String name) {
            Node node = new Node(name);
            if (tail == null) {
                node.next = node;
                tail = node;
                return;
            }
            node.next = tail.next;
            tail.next = node;
            tail = node;
        }

        void printTurns(int turns) {
            if (tail == null) return;
            StringBuilder sb = new StringBuilder();
            Node cur = tail.next;
            for (int i = 0; i < turns; i++) {
                sb.append(cur.name);
                if (i != turns - 1) sb.append(" ");
                cur = cur.next;
            }
            System.out.println(sb);
        }
    }

    public static void main(String[] args) {
        PlayerCircle circle = new PlayerCircle();
        circle.addLast("Asha");
        circle.addLast("Ravi");
        circle.addLast("Neha");

        circle.printTurns(7);
    }
}