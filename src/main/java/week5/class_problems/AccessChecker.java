package week5.class_problems;

class AccessChecker1 {

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

    static String summarizeBatch(String[][] attempts) {
        int allowed = 0, denied = 0;
        for (String[] attempt : attempts) {
            if (classifyAccess(attempt[0], attempt[1]).equals("ALLOWED")) allowed++;
            else denied++;
        }
        return "Allowed: " + allowed + " | Denied: " + denied;
    }
}

class MovieTicket {
    private int seatNumber;
    String screenId;
    protected double ticketPrice;
    public String movieTitle;
}

public class AccessCheckerProblem1 {
    public static void main(String[] args) {
        System.out.println(AccessChecker1.classifyAccess("private", "SAME_CLASS"));
        System.out.println(AccessChecker1.classifyAccess("protected", "DIFFERENT_PACKAGE"));

        String[][] batch = {
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"public", "DIFFERENT_PACKAGE"}
        };
        System.out.println(AccessChecker1.summarizeBatch(batch));
    }
}