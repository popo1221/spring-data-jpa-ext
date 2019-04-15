package org.ling.data.jpa.ext.operator;

import org.ling.data.jpa.ext.ExpressionHolder;
import org.ling.data.jpa.ext.Operator;

import java.util.List;

public class SubstringOperator<T> extends AbstractOperator<T> implements ExpressionOperator<T> {
    public SubstringOperator(Object value, List<Operator<T>> children) {
        super(value, children);
    }


    String toString(ConstOperator x) {
        return (String) x.toObject();
    }

    Integer toInteger(ConstOperator x) {
        return (Integer) x.toObject();
    }


    <T> ExpressionHolder<T> toExpressionHolder(ExpressionOperator<T> y) {
        return y.toExpressionHolder();
    }

    @Override
    public ExpressionHolder<String> toExpressionHolder() {


        Operator<?> x = children.get(0);
        Operator<?> from = children.get(1);
        ExpressionHolder<String> xObj = toExpressionHolder((ExpressionOperator<String>) x);
        if (children.size() >= 3) {
            Operator<?> len = children.get(2);

            if (from instanceof ExpressionOperator) {
                ExpressionHolder<Integer> fromObj = toExpressionHolder((ExpressionOperator<Integer>) from);
                ExpressionHolder<Integer> lenObj = toExpressionHolder((ExpressionOperator<Integer>) len);

                return SubstringExpressionHolder.create(xObj, fromObj, lenObj);
            }

            Integer fromObj = toInteger((ConstOperator) from);
            Integer lenObj = toInteger((ConstOperator) len);

            return SubstringExpressionHolder.create(xObj, fromObj, lenObj);
        }


        if (from instanceof ExpressionOperator) {
            ExpressionHolder<Integer> fromObj = toExpressionHolder((ExpressionOperator<Integer>) from);

            return SubstringExpressionHolder.create(xObj, fromObj);
        }

        Integer fromObj = toInteger((ConstOperator) from);

        return SubstringExpressionHolder.create(xObj, fromObj);
    }
}