import java.util.*;

public class ScoreBand {
    static int lowerBound(int[] s, int x) {
        int lo = 0, hi = s.length;
        while (lo < hi) {
            int m = (lo + hi) >>> 1;
            if (s[m] < x) lo = m + 1;
            else hi = m;
        }
        return lo;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] s = new int[sc.nextInt()];
        for (int i = 0; i < s.length; i++) s[i] = sc.nextInt();
        while (sc.hasNext()) {
            sc.next();
            int x = sc.nextInt(), b = lowerBound(s, x);
            System.out.println(x + ": exactly " + (lowerBound(s, x + 1) - b) + ", below " + b);
        }
    }
}