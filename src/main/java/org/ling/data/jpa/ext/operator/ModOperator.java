package org.ling.data.jpa.ext.operator;

import org.ling.data.jpa.ext.ExpressionHolder;
import org.ling.data.jpa.ext.Operator;

import java.util.List;

public class ModOperator<T> extends AbstractOperator<T> implements ExpressionOperator<T> {
    public ModOperator(Object value, List<Operator<T>> children) {
        super(value, children);
    }


    Integer toNumber(ConstOperator x) {
        return (Integer) x.toObject();
    }


    ExpressionHolder<Integer> toExpressionHolder(ExpressionOperator<Integer> y) {
        return y.toExpressionHolder();
    }

    @Override
    public ExpressionHolder<Integer> toExpressionHolder() {

        Operator<?> x = children.get(0);
        Operator<?> y = children.get(1);


        if (x instanceof ExpressionOperator) {
            if (y instanceof ExpressionOperator) {
                ExpressionHolder<Integer> xObj = toExpressionHolder((ExpressionOperator<Integer>) x);
                ExpressionHolder<Integer> yObj = toExpressionHolder((ExpressionOperator<Integer>) y);
                return ModExpressionHolder.create(xObj, yObj);
            } else {
                ExpressionHolder<Integer> xObj = toExpressionHolder((ExpressionOperator<Integer>) x);
                Integer yObj = toNumber((ConstOperator) y);
                return ModExpressionHolder.create(xObj, yObj);
            }
        } else {
            Integer xObj = toNumber((ConstOperator) x);
            ExpressionHolder<Integer> yObj = toExpressionHolder((ExpressionOperator<Integer>) y);
            return ModExpressionHolder.create(xObj, yObj);
        }
    }
}