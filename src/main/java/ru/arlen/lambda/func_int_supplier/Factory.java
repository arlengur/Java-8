package ru.arlen.lambda.func_int_supplier;

import java.util.function.Supplier;

/**
 * @author Alexey Galin <arlengur@rambler.ru>
 */
public class Factory<T> {
    public T get(Supplier<? extends T> supplier) {
        T t = supplier.get();
        System.out.println(t + " was created...");
        return t;
    }
}
