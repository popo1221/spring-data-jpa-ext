package org.ling.data.jpa.ext.operator;

import org.ling.data.jpa.ext.Operator;
import org.ling.data.jpa.ext.specification.BetweenSpecification;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class BetweenOperator<T> extends AbstractOperator<T> implements SpecificationOperator<T> {
    public BetweenOperator(Object value, List<Operator<T>> children) {
        super(value, children);
    }

    @Override
    public Specification<T> toSpecification() {
        return new BetweenSpecification<>(getObjectOrExpression(children.get(0)),
                getObjectOrExpression(children.get(1)),
                getObjectOrExpression(children.get(2)));
    }
}
