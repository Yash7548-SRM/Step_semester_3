package week11.assigment_problems;

public class PlacementCutoff {

    static int kthHighest(int[] marks, int k) {
        int[] arr = marks.clone();
        int target = arr.length - k;
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int p = partition(arr, low, high);
            if (p == target) return arr[p];
            if (p < target) low = p + 1;
            else high = p - 1;
        }
        return -1;
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }

    public static void main(String[] args) {
        System.out.println(kthHighest(new int[]{72, 95, 60, 88, 79}, 2));
        System.out.println(kthHighest(new int[]{50, 90, 90, 70}, 2));
    }
}