package week9.assigment_problems;

import java.util.HashMap;

public class MostPopularCanteenOrder {

    static String mostPopular(String[] orders) {
        HashMap<String, Integer> counts = new HashMap<>();
        for (String item : orders) {
            counts.put(item, counts.getOrDefault(item, 0) + 1);
        }

        String bestItem = null;
        int bestCount = 0;
        for (String item : orders) {
            int count = counts.get(item);
            if (count > bestCount) {
                bestCount = count;
                bestItem = item;
            }
        }

        return "(\"" + bestItem + "\", " + bestCount + ")";
    }

    public static void main(String[] args) {
        String[] a = {"dosa", "idli", "vada", "dosa", "idli", "dosa", "tea"};
        String[] b = {"tea", "coffee", "coffee", "tea"};

        System.out.println(mostPopular(a));
        System.out.println(mostPopular(b));
    }
}