import java.util.*;

public class Leaderboard {
    static class Participant {
        String name;
        int score;
        Participant(String n, int s) { name = n; score = s; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Participant> l = new ArrayList<>();
        while (sc.hasNext()) l.add(new Participant(sc.next(), sc.nextInt()));
        Participant[] p = l.toArray(new Participant[0]);
        for (int i = 1; i < p.length; i++) {
            Participant key = p[i];
            int j = i - 1;
            while (j >= 0 && p[j].score < key.score) { p[j + 1] = p[j]; j--; }
            p[j + 1] = key;
        }
        int rank = 1;
        for (int i = 0; i < p.length; i++) {
            if (i > 0 && p[i].score != p[i - 1].score) rank = i + 1;
            System.out.println(rank + " " + p[i].name + " " + p[i].score);
        }
    }
}