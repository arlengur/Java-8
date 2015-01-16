package ru.arlen.lambda.func_int_consumer;

import java.util.function.Consumer;

/**
 * @author Alexey Galin <arlengur@rambler.ru>
 */
public class Bank {
    public static void main(String[] args) {
        Customer customer = new Customer("000-00-0000", 5000.0);
        updateBalance(customer, c -> c.setBalance(c.getBalance() + 2000.0));
        System.out.println("----------------------------");
        updateBalance(customer, c -> c.setBalance(c.getBalance() - 500.0));
    }

    public static void updateBalance(Customer customer, Consumer<Customer> consumer) {
        System.out.println("Social Security Number: " + customer.getSsn());
        System.out.println("Balance before transaction: " + customer.getBalance());
        consumer.accept(customer);
        System.out.println("Balance after transaction: " + customer.getBalance());
    }
}
