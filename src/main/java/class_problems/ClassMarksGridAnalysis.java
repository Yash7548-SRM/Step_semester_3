package week10.class_problems;

import java.util.Locale;

public class ClassMarksGridAnalysis {

    public static void main(String[] args) {
        String[] lines = {
            "Asha [78, 85, 90]",
            "Ravi [88, 92, 79]",
            "Neha [65, 70, 95]"
        };

        int n = lines.length;
        String[] names = new String[n];
        int[][] marks = new int[n][3];

        for (int i = 0; i < n; i++) {
            int open = lines[i].indexOf('[');
            int close = lines[i].indexOf(']');
            names[i] = lines[i].substring(0, open).trim();
            String[] parts = lines[i].substring(open + 1, close).split(",");
            for (int j = 0; j < 3; j++) {
                marks[i][j] = Integer.parseInt(parts[j].trim());
            }
        }

        int[] totals = new int[n];
        int topperIndex = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                totals[i] += marks[i][j];
            }
            if (totals[i] > totals[topperIndex]) topperIndex = i;
        }

        StringBuilder totalsLine = new StringBuilder("Totals ");
        for (int i = 0; i < n; i++) {
            totalsLine.append(names[i]).append(" ").append(totals[i]);
            if (i != n - 1) totalsLine.append(", ");
        }
        System.out.println(totalsLine);

        StringBuilder avgLine = new StringBuilder("averages ");
        for (int j = 0; j < 3; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) sum += marks[i][j];
            avgLine.append(String.format(Locale.US, "%.2f", (double) sum / n));
            if (j != 2) avgLine.append(", ");
        }
        System.out.println(avgLine);

        System.out.println("topper " + names[topperIndex] + " (" + totals[topperIndex] + ")");
    }
}