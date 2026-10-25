package week9.assigment_problems;

public class HotWeatherAlertWindows {

    static int countAlerts(int[] readings, int k, int threshold) {
        long required = (long) k * threshold;
        long sum = 0;
        int count = 0;

        for (int i = 0; i < readings.length; i++) {
            sum += readings[i];
            if (i >= k) sum -= readings[i - k];
            if (i >= k - 1 && sum >= required) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] readings = {2, 2, 2, 2, 5, 5, 5, 8};
        System.out.println(countAlerts(readings, 3, 4));
    }
}