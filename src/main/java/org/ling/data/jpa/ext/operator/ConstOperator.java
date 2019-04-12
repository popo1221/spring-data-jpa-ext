package org.ling.data.jpa.ext.operator;

import org.ling.data.jpa.ext.Operator;

import java.util.List;

public class ConstOperator<T> extends AbstractOperator<T> implements Operator<T> {

    public ConstOperator(Object value, List<Operator<T>> children) {
        super(value, children);
    }

    public <Y> Y toObject() {
        return (Y) this.value;
    }
}
