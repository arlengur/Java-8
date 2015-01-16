package ru.arlen.lambda.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author Alexey Galin <arlengur@rambler.ru>
 */
public class FunctionDemo<X, Y> {
    public List<Y> applyFunc(Function<X, Y> function, List<X> list) {
        List<Y> retType = new ArrayList<>();
        list.forEach(x -> retType.add(function.apply(x)));
        return retType;
    }

    public List<Y> applyFuncAndThen(Function<X, Y> function1, Function<Y, Y> function2, List<X> list) {
        List<Y> retType = new ArrayList<>();
        list.forEach(x -> retType.add(function1.andThen(function2).apply(x)));
        return retType;
    }

    public List<Y> applyFuncCompose(Function<Y, Y> function1, Function<X, Y> function2, List<X> list) {
        List<Y> retType = new ArrayList<>();
        list.forEach(x -> retType.add(function1.compose(function2).apply(x)));
        return retType;
    }
}
