import java.util.*;

public class Timetable {
    List<String> periods;

    Timetable(List<String> p) { periods = p; }

    Timetable copy() { return new Timetable(new ArrayList<>(periods)); }

    void setPeriod(int period, String subject) { periods.set(period - 1, subject); }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        int n = sc.nextInt();
        List<String> l = new ArrayList<>();
        for (int i = 0; i < n; i++) l.add(sc.next());
        Timetable t1 = new Timetable(l), t2 = t1.copy();
        String b = sc.next();
        t2.setPeriod(sc.nextInt(), sc.next());
        System.out.println(a + ": " + t1.periods);
        System.out.println(b + ": " + t2.periods);
    }
}