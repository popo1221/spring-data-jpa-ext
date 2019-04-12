package org.ling.data.jpa.ext.operator;

import org.ling.data.jpa.ext.Operator;
import org.ling.data.jpa.ext.specification.GreaterThanSpecification;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class GreaterThanOperator<T> extends AbstractOperator<T> implements SpecificationOperator<T> {

    public GreaterThanOperator(Object value, List<Operator<T>> children) {
        super(value, children);
    }

    @Override
    public Specification<T> toSpecification() {
        return new GreaterThanSpecification<>(getObjectOrExpression(children.get(0)), getObjectOrExpression(children.get(1)));
    }
}
