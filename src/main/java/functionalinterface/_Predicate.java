package functionalinterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        System.out.println("Without Predicate");
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("09000000000"));
        System.out.println("Predicate");
        System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("09000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("0900000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("070000000000"));

        System.out.println(
                "Is phone number valid and contains number 3 = "+
                isPhoneNumberValidPredicate.or(containsNumber3).test("07000009990")
        );

        System.out.println(
                "Is phone number valid and contains number 3 = "+
                        isPhoneNumberValidPredicate.or(containsNumber3).test("01000000000")
        );


    }

    static boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("07")&&phoneNumber.length()==11;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("07")&&phoneNumber.length()==11;

    static Predicate<String> containsNumber3 = phoneNumber ->
            phoneNumber.contains("3");

}
