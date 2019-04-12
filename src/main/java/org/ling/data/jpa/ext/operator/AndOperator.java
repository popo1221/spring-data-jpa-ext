package org.ling.data.jpa.ext.operator;


import org.ling.data.jpa.ext.Operator;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class AndOperator<T> extends AbstractOperator<T> implements SpecificationOperator<T> {

    public AndOperator(Object value, List<Operator<T>> children) {
        super(value, children);
    }

    @Override
    public Specification<T> toSpecification() {

        if (children.isEmpty()) {
            return null;
        }

        Specification<T> current = null;
        for (Operator<T> operator : this.getChildren()) {
            SpecificationOperator<T> specificationOperator = (SpecificationOperator<T>) operator;
            if (current == null) {
                current = specificationOperator.toSpecification();
            } else {
                current = current.and(specificationOperator.toSpecification());
            }
        }

        return current;
    }
}
