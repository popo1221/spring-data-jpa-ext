package org.ling.data.jpa.ext.operator;

import org.ling.data.jpa.ext.Operator;
import org.ling.data.jpa.ext.specification.EqualSpecification;
import org.ling.data.jpa.ext.specification.IsEmptySpecification;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class IsEmptyOperator<T> extends AbstractOperator<T> implements SpecificationOperator<T> {

    public IsEmptyOperator(Object value, List<Operator<T>> children) {
        super(value, children);
    }

    @Override
    public Specification<T> toSpecification() {
        return new IsEmptySpecification<>(getObjectOrExpression(children.get(0)));
    }
}
