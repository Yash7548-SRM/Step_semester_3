package week11.assigment_problems;

public class AttendanceDisorderScore {

    static long countInversions(int[] roll) {
        int[] copy = roll.clone();
        int[] temp = new int[copy.length];
        return mergeSort(copy, temp, 0, copy.length - 1);
    }

    static long mergeSort(int[] arr, int[] temp, int lo, int hi) {
        if (lo >= hi) return 0;
        int mid = lo + (hi - lo) / 2;
        long count = mergeSort(arr, temp, lo, mid) + mergeSort(arr, temp, mid + 1, hi);

        int i = lo, j = mid + 1, k = lo;
        while (i <= mid && j <= hi) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count += mid - i + 1;
            }
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= hi) temp[k++] = arr[j++];
        for (int x = lo; x <= hi; x++) arr[x] = temp[x];

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countInversions(new int[]{2, 4, 1, 3, 5}));
        System.out.println(countInversions(new int[]{5, 4, 3, 2, 1}));
    }
}