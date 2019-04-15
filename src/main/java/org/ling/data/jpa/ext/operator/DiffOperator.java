package org.ling.data.jpa.ext.operator;

import org.ling.data.jpa.ext.ExpressionHolder;
import org.ling.data.jpa.ext.Operator;

import java.util.List;

public class DiffOperator<T> extends AbstractOperator<T> implements ExpressionOperator<T> {
    public DiffOperator(Object value, List<Operator<T>> children) {
        super(value, children);
    }


    <T extends Number> T toNumber(ConstOperator x) {
        return (T) x.toObject();
    }


    ExpressionHolder<? extends Number> toExpressionHolder(ExpressionOperator<? extends Number> y) {
        return y.toExpressionHolder();
    }

    @Override
    public ExpressionHolder<Number> toExpressionHolder() {

        Operator<?> x = children.get(0);
        Operator<?> y = children.get(1);


        if (x instanceof ExpressionOperator) {
            if (y instanceof ExpressionOperator) {
                ExpressionHolder<? extends Number> xObj = toExpressionHolder((ExpressionOperator<? extends  Number>) x);
                ExpressionHolder<? extends Number> yObj = toExpressionHolder((ExpressionOperator<? extends  Number>) y);
                return DiffExpressionHolder.create(xObj, yObj);
            } else {
                ExpressionHolder<? extends Number> xObj = toExpressionHolder((ExpressionOperator<? extends  Number>) x);
                Number yObj = toNumber((ConstOperator) y);
                return DiffExpressionHolder.create(xObj, yObj);
            }
        } else {
            Number xObj = toNumber((ConstOperator) x);
            ExpressionHolder<? extends Number> yObj = toExpressionHolder((ExpressionOperator<? extends  Number>) y);
         return DiffExpressionHolder.create(xObj, yObj);
        }
    }
}