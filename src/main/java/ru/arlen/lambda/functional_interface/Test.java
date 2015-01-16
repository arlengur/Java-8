package ru.arlen.lambda.functional_interface;

/**
 * Hello world!
 */
public class Test {
    public static void main(String[] args) {
        FirstFuncInterf funcInterf1 = new FirstFuncInterf() {
            @Override
            public void doTask() {
                System.out.println("Hello");
            }
        };

        FirstFuncInterf funcInterf2 = ()-> System.out.println("Hello, Guy");

        funcInterf1.doTask();
        funcInterf2.doTask();
    }
}
