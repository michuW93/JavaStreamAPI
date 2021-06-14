package FunctionalProgramming;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        Customer customer = new Customer("Patricia", "+48502212212");
        greetCustomer(customer);
        greetCustomer.accept(customer);
        greetConsumerWithHidingPhoneNumber.accept(customer, true);
        greetConsumerWithHidingPhoneNumber.accept(customer, false);
    }

    private static BiConsumer<Customer, Boolean> greetConsumerWithHidingPhoneNumber = (customer, showPhoneNumber) ->
            System.out.println("Hello " + customer.getName()
                    + " to register number: " + (showPhoneNumber ? customer.getNumber() : "**********"));

    private static Consumer<Customer> greetCustomer = customer -> System.out.println("Hello " + customer.getName()
            + " to register number: " + customer.getNumber());


    private static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.getName() + " to register number: " + customer.getNumber());
    }

    static class Customer {
        private final String name;
        private final String number;

        public Customer(String name, String number) {
            this.name = name;
            this.number = number;
        }

        public String getName() {
            return name;
        }

        public String getNumber() {
            return number;
        }
    }
}
