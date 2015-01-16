package ru.arlen.lambda.func_int_supplier;

/**
 * @author Alexey Galin <arlengur@rambler.ru>
 */
public class Test {
    public static void main(String[] args) {
        Factory<Shape> factory = new Factory<>();
        Shape shape = factory.get(() -> new Triangle());
        shape.sketch();
    }
}

