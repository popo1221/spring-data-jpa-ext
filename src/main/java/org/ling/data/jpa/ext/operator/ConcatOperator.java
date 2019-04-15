package org.ling.data.jpa.ext.operator;

import org.ling.data.jpa.ext.ExpressionHolder;
import org.ling.data.jpa.ext.Operator;

import java.util.List;

public class ConcatOperator<T> extends AbstractOperator<T> implements ExpressionOperator<T> {
    public ConcatOperator(Object value, List<Operator<T>> children) {
        super(value, children);
    }


    String toString(ConstOperator x) {
        return (String) x.toObject();
    }


    ExpressionHolder<String> toExpressionHolder(ExpressionOperator<String> y) {
        return y.toExpressionHolder();
    }

    @Override
    public ExpressionHolder<String> toExpressionHolder() {

        Operator<?> x = children.get(0);
        Operator<?> y = children.get(1);


        if (x instanceof ExpressionOperator) {
            if (y instanceof ExpressionOperator) {
                ExpressionHolder<String> xObj = toExpressionHolder((ExpressionOperator<String>) x);
                ExpressionHolder<String> yObj = toExpressionHolder((ExpressionOperator<String>) y);
                return ConcatExpressionHolder.create(xObj, yObj);
            } else {
                ExpressionHolder<String> xObj = toExpressionHolder((ExpressionOperator<String>) x);
                String yObj = toString((ConstOperator) y);
                return ConcatExpressionHolder.create(xObj, yObj);
            }
        } else {
            String xObj = toString((ConstOperator) x);
            ExpressionHolder<String> yObj = toExpressionHolder((ExpressionOperator<String>) y);
         return ConcatExpressionHolder.create(xObj, yObj);
        }
    }
}