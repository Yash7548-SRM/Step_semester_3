package week5.class_problems;

class AccessChecker2 {

    static String classifyAccess(String fieldModifier, String accessorContext) {
        switch (fieldModifier) {
            case "private":
                return accessorContext.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";
            case "default":
                return accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE") ? "ALLOWED" : "DENIED";
            case "protected":
                if (accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE")) return "ALLOWED";
                if (accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) return "ALLOWED";
                return "DENIED";
            case "public":
                return "ALLOWED";
            default:
                return "DENIED";
        }
    }
}

class MovieTicket2 {
    private int seatNumber;
    String screenId;
    protected double ticketPrice;
    public String movieTitle;
}

class PremiumMovieTicket extends MovieTicket2 {
}

public class AccessCheckerProblem2 {
    public static void main(String[] args) {
        System.out.println(AccessChecker2.classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));
        System.out.println(AccessChecker2.classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));
    }
}