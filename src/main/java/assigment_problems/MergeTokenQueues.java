package week9.assigment_problems;

import java.util.Arrays;

public class MergeTokenQueues {

    static int[] mergeTokens(int[] counterA, int[] counterB) {
        int[] result = new int[counterA.length + counterB.length];
        int i = 0, j = 0, k = 0;

        while (i < counterA.length && j < counterB.length) {
            if (counterA[i] <= counterB[j]) result[k++] = counterA[i++];
            else result[k++] = counterB[j++];
        }
        while (i < counterA.length) result[k++] = counterA[i++];
        while (j < counterB.length) result[k++] = counterB[j++];

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeTokens(new int[]{3, 8, 15, 20}, new int[]{5, 8, 12})));
        System.out.println(Arrays.toString(mergeTokens(new int[]{}, new int[]{4, 9})));
    }
}