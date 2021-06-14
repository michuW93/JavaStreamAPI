package FunctionalProgramming;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        String polishPhoneNumber = "+48901234945";
        String otherPhoneNumber = "+39123123123";

        isPhoneNumberPolish.test(polishPhoneNumber);
        isPhoneNumberPolish.test(otherPhoneNumber);

        isPhoneNumberPolish.and(isPhoneNumberCorrectLength).test(polishPhoneNumber);
    }

    private static Predicate<String> isPhoneNumberPolish = number -> number.startsWith("+48");

    private static Predicate<String> isPhoneNumberCorrectLength = number -> number.length() == 12;
}
