package week2.class_problems;

public class BankTransactionReferenceValidator {

    static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        String bankCode = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        return bankCode + rest;
    }

    static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        String bankCode = reference.substring(0, 3);
        String body = reference.substring(3);

        for (int i = 0; i < bankCode.length(); i++) {
            if (!Character.isLetter(bankCode.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 0; i < body.length(); i++) {
            if (!Character.isDigit(body.charAt(i))) {
                return "Invalid: body must be digits";
            }
        }

        String date = body.substring(0, 6);
        String seq = body.substring(6);
        String dd = date.substring(0, 2);
        String mm = date.substring(2, 4);
        String yy = date.substring(4, 6);

        StringBuilder result = new StringBuilder();
        result.append("[").append(bankCode).append("] DATE: ").append(dd).append("/").append(mm).append("/").append(yy).append(" | SEQ: ").append(seq);

        return result.toString();
    }

    public static void main(String[] args) {
        String normalized1 = normalizeReference(" hdf03022600042 ");
        System.out.println(validateAndFormat(normalized1));

        String normalized2 = normalizeReference("12F03022600042");
        System.out.println(validateAndFormat(normalized2));
    }
}