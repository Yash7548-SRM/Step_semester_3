import java.util.*;

public class Shifter {
    static String shiftNotice(String text, int k) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c >= 'a' && c <= 'z') sb.append((char) ((c - 'a' + k) % 26 + 'a'));
            else if (c >= 'A' && c <= 'Z') sb.append((char) ((c - 'A' + k) % 26 + 'A'));
            else sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        int k = sc.nextInt();
        System.out.println(shiftNotice(text, k));
    }
}