package optionals;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Object value = Optional.ofNullable(null)
                .orElseGet(() -> "default vaue");

        System.out.println(value);


        Optional.ofNullable(null)
                .ifPresentOrElse(email -> System.out.println("Sending email to "+email),() -> {
                    System.out.println("Can't send email");
                });
    }
}
