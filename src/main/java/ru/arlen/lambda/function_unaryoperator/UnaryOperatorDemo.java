package ru.arlen.lambda.function_unaryoperator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 * @author Alexey Galin <arlengur@rambler.ru>
 */
public class UnaryOperatorDemo<X> {
    public List<X> applyFunc(UnaryOperator<X> unaryOperator, List<X> list) {
        List<X> retType = new ArrayList<>();
        list.forEach(x -> retType.add(unaryOperator.apply(x)));
        return retType;
    }
    public List<X> applyFuncAndThen(UnaryOperator<X> unaryOp1, UnaryOperator<X> unaryOp2, List<X> list) {
        List<X> retType = new ArrayList<>();
        list.forEach(x -> retType.add(unaryOp1.andThen(unaryOp2).apply(x)));
        return retType;
    }
    public List<X> applyFuncCompose(UnaryOperator<X> unaryOp1, UnaryOperator<X> unaryOp2, List<X> list) {
        List<X> retType = new ArrayList<>();
        list.forEach(x -> retType.add(unaryOp1.compose(unaryOp2).apply(x)));
        return retType;
    }
}
