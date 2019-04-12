package org.ling.data.jpa.ext.operator;

import org.ling.data.jpa.ext.Operator;
import org.ling.data.jpa.ext.specification.LikeSpecification;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class LikeOperator<T> extends AbstractOperator<T> implements SpecificationOperator<T> {

    public LikeOperator(Object value, List<Operator<T>> children) {
        super(value, children);
    }

    @Override
    public Specification<T> toSpecification() {

        return new LikeSpecification<>(getObjectOrExpression(children.get(0)), getObjectOrExpression(children.get(1)));
    }
}
