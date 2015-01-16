package ru.arlen.lambda.func_int_supplier;

/**
 * @author Alexey Galin <arlengur@rambler.ru>
 */
public interface Shape {
    void sketch();
}

class Rectangle implements Shape {
    @Override
    public void sketch() {
        System.out.println("Rectangle.sketch invoked...");
    }

    @Override
    public String toString() {
        return "Rectangle";
    }
}
class Triangle implements Shape {
    @Override
    public void sketch() {
        System.out.println("Triangle.sketch invoked...");
    }

    @Override
    public String toString() {
        return "Triangle";
    }
}
class Circle implements Shape {
    @Override
    public void sketch() {
        System.out.println("Circle.sketch invoked...");
    }

    @Override
    public String toString() {
        return "Circle";
    }
}