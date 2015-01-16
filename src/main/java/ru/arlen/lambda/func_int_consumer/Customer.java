package ru.arlen.lambda.func_int_consumer;

/**
 * @author Alexey Galin <arlengur@rambler.ru>
 */
public class Customer {
    private String ssn;
    private Double balance;

    public Customer(String ssn, Double balance) {
        this.ssn = ssn;
        this.balance = balance;
    }

    public String getSsn() {
        return ssn;
    }

    public Double getBalance() {

        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
