package org.ling.data.jpa.ext.operator;

import org.ling.data.jpa.ext.Operator;
import org.ling.data.jpa.ext.specification.IsEmptySpecification;
import org.ling.data.jpa.ext.specification.IsNotEmptySpecification;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class IsNotEmptyOperator<T> extends AbstractOperator<T> implements SpecificationOperator<T> {

    public IsNotEmptyOperator(Object value, List<Operator<T>> children) {
        super(value, children);
    }

    @Override
    public Specification<T> toSpecification() {
        return new IsNotEmptySpecification<>(getObjectOrExpression(children.get(0)));
    }
}
