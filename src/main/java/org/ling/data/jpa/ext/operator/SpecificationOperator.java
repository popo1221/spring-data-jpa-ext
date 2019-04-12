package org.ling.data.jpa.ext.operator;

import org.ling.data.jpa.ext.Operator;
import org.springframework.data.jpa.domain.Specification;

public interface SpecificationOperator<T> extends Operator<T> {
    Specification<T> toSpecification();
}
