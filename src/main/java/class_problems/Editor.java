import java.util.*;

public class Editor {
    String[] a;
    int top = -1;

    Editor(int n) { a = new String[n]; }

    void type(String w) {
        if (top == a.length - 1) { System.out.println("rejected: history full"); return; }
        a[++top] = w;
        show();
    }

    void undo() {
        if (top == -1) { System.out.println("rejected: nothing to undo"); return; }
        top--;
        show();
    }

    void show() {
        System.out.println(top == -1 ? "(empty)" : String.join(" ", Arrays.copyOf(a, top + 1)));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Editor e = new Editor(sc.nextInt());
        while (sc.hasNext()) {
            if (sc.next().equals("TYPE")) e.type(sc.next());
            else e.undo();
        }
    }
}