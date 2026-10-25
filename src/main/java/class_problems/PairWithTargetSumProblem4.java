package week9.class_problems;

import java.util.Arrays;
import java.util.HashSet;

public class PairWithTargetSumProblem4 {

    static boolean hasPairBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return true;
            }
        }
        return false;
    }

    static boolean hasPairSortedTwoPointers(int[] nums, int target) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        int left = 0, right = sorted.length - 1;
        while (left < right) {
            int sum = sorted[left] + sorted[right];
            if (sum == target) return true;
            if (sum < target) left++;
            else right--;
        }
        return false;
    }

    static boolean hasPairHashing(int[] nums, int target) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(target - num)) return true;
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        int[] b = {3, 4, 6};

        System.out.println(hasPairBruteForce(a, 9));
        System.out.println(hasPairBruteForce(b, 20));
        System.out.println(hasPairSortedTwoPointers(a, 9));
        System.out.println(hasPairSortedTwoPointers(b, 20));
        System.out.println(hasPairHashing(a, 9));
        System.out.println(hasPairHashing(b, 20));
    }
}