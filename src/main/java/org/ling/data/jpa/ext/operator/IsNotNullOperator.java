package org.ling.data.jpa.ext.operator;

import org.ling.data.jpa.ext.Operator;
import org.ling.data.jpa.ext.specification.IsNotNullSpecification;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class IsNotNullOperator<T> extends AbstractOperator<T> implements SpecificationOperator<T> {

    public IsNotNullOperator(Object value, List<Operator<T>> children) {
        super(value, children);
    }

    @Override
    public Specification<T> toSpecification() {
        return new IsNotNullSpecification<>(getObjectOrExpression(children.get(0)));
    }
}
