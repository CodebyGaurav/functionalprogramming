package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {

        //Normal Java function
        Customer maria = new Customer("Maria","124352235");
        greetCustomer(maria);
        greetCustomerV2(maria,false);
        //Consumer Function Interface
        greetCustomerConsumer.accept(maria);

        greetCustomerConsumerV2.accept(maria,false);

    }

    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) ->
            System.out.println("Hello "+customer.customerName+
                    ", thanks for registered phone number "
                    +(showPhoneNumber ? customer.customerPhoneName:"*************"));

    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello "+customer.customerName+
                    ", thanks for registered phone number "+customer.customerPhoneName);

    static void greetCustomer(Customer customer){
        System.out.println("Hello "+customer.customerName+ ", thanks for registered phone number "+customer.customerPhoneName);
    }

    static void greetCustomerV2(Customer customer,boolean showPhoneNumber){
        System.out.println("Hello "+customer.customerName+
                ", thanks for registered phone number "
                +(showPhoneNumber ? customer.customerPhoneName:"*************"));
    }

    static class Customer{
        private final String customerName;
        private final String customerPhoneName;

        public Customer(String customerName, String customerPhoneName) {
            this.customerName = customerName;
            this.customerPhoneName = customerPhoneName;
        }
    }

}
