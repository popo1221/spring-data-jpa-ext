package org.ling.data.jpa.ext.operator;

import org.ling.data.jpa.ext.ExpressionHolder;
import org.ling.data.jpa.ext.Operator;


public interface ExpressionOperator<T> extends Operator<T> {
    <Y> ExpressionHolder<Y> toExpressionHolder();
}
