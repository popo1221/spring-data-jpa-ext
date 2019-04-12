package org.ling.data.jpa.ext.operator;

import org.ling.data.jpa.ext.Operator;
import org.ling.data.jpa.ext.specification.LessThanOrEqualToSpecification;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class LessThanOrEqualToOperator<T> extends AbstractOperator<T> implements SpecificationOperator<T> {

    public LessThanOrEqualToOperator(Object value, List<Operator<T>> children) {
        super(value, children);
    }

    @Override
    public Specification<T> toSpecification() {
        return new LessThanOrEqualToSpecification<>(getObjectOrExpression(children.get(0)), getObjectOrExpression(children.get(1)));
    }
}
