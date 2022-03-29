package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegisterationValidator.*;
import static combinatorpattern.CustomerRegisterationValidator.ValidationResult.SUCCESS;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "laice@gmail.com",
                "+09100202000002",
                LocalDate.of(2000,1,1)
        );

        System.out.println(new CustomerValidatorService().isValid(customer));
        System.out.println("------------------------------------------------------------------------------------------------");

        //if valid We can store customer in db

        //Using Combinator PAttern
        ValidationResult result =
                isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAnAdult())
                .apply(customer);

        System.out.println(result);

        if (result != SUCCESS) {
            throw new IllegalStateException(result.name());
        }


    }
}
