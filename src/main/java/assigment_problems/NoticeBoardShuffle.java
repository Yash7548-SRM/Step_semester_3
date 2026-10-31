package week11.assigment_problems;

import java.util.Arrays;

public class NoticeBoardShuffle {

    static int[] bubbleStats(int[] scores) {
        int passes = 0, swaps = 0;
        int n = scores.length;
        for (int i = 0; i < n - 1; i++) {
            passes++;
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (scores[j] > scores[j + 1]) {
                    int temp = scores[j];
                    scores[j] = scores[j + 1];
                    scores[j + 1] = temp;
                    swaps++;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return new int[]{passes, swaps};
    }

    public static void main(String[] args) {
        int[] a = {5, 1, 4, 2, 8};
        int[] statsA = bubbleStats(a);
        System.out.println(Arrays.toString(a) + " passes = " + statsA[0] + ", swaps = " + statsA[1]);

        int[] b = {1, 2, 3, 4};
        int[] statsB = bubbleStats(b);
        System.out.println(Arrays.toString(b) + " passes = " + statsB[0] + ", swaps = " + statsB[1]);
    }
}