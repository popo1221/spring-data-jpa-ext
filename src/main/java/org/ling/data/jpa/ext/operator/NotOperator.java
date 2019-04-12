package org.ling.data.jpa.ext.operator;


import org.ling.data.jpa.ext.Operator;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class NotOperator<T> extends AbstractOperator<T> implements SpecificationOperator<T> {

    public NotOperator(Object value, List<Operator<T>> children) {
        super(value, children);
    }

    @Override
    public Specification<T> toSpecification() {

        if (children.isEmpty()) {
            return null;
        }

        return Specification.not(((SpecificationOperator<T>) children.get(0)).toSpecification());
    }

    ;
}
