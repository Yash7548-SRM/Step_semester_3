package week5.assigment_problems;

import java.util.*;

class AccessCheckerA1 {

    static String classifyAccess(String fieldModifier, String accessorContext) {
        switch (fieldModifier) {
            case "private":
                return accessorContext.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";
            case "default":
                return accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE") ? "ALLOWED" : "DENIED";
            case "protected":
                return accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE") ? "ALLOWED" : "DENIED";
            case "public":
                return "ALLOWED";
            default:
                return "DENIED";
        }
    }

    static String summarizeByModifier(String[][] attempts) {
        String[] modifiers = {"private", "default", "protected", "public"};
        int[] allowedCount = new int[4];
        int[] deniedCount = new int[4];

        for (String[] attempt : attempts) {
            String modifier = attempt[0];
            String result = classifyAccess(attempt[0], attempt[1]);

            for (int i = 0; i < modifiers.length; i++) {
                if (modifiers[i].equals(modifier)) {
                    if (result.equals("ALLOWED")) allowedCount[i]++;
                    else deniedCount[i]++;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < modifiers.length; i++) {
            result.append(modifiers[i]).append(": ").append(allowedCount[i]).append(" allowed / ").append(deniedCount[i]).append(" denied");
            if (i != modifiers.length - 1) result.append(" | ");
        }

        return result.toString();
    }
}

class LibraryMember1 {
    private String membershipPin;
    String branchCode;
    String finesOwed;
    public String displayName;
}

public class AccessCheckerAssignment1 {
    public static void main(String[] args) {
        System.out.println(AccessCheckerA1.classifyAccess("private", "SAME_CLASS"));
        System.out.println(AccessCheckerA1.classifyAccess("protected", "DIFFERENT_PACKAGE"));

        String[][] batch = {
            {"private", "SAME_CLASS"},
            {"private", "SAME_PACKAGE"},
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"protected", "SAME_PACKAGE"},
            {"protected", "SAME_CLASS"},
            {"public", "DIFFERENT_PACKAGE"}
        };
        System.out.println(AccessCheckerA1.summarizeByModifier(batch));
    }
}