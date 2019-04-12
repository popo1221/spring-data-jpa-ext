package org.ling.data.jpa.ext.operator;

import org.ling.data.jpa.ext.Operator;
import org.ling.data.jpa.ext.specification.IsNullSpecification;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class IsNullOperator<T> extends AbstractOperator<T> implements SpecificationOperator<T> {

    public IsNullOperator(Object value, List<Operator<T>> children) {
        super(value, children);
    }

    @Override
    public Specification<T> toSpecification() {
        return new IsNullSpecification<>(getObjectOrExpression(children.get(0)));
    }
}
