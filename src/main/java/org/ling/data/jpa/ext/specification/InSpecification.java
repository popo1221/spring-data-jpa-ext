package org.ling.data.jpa.ext.specification;

import org.ling.data.jpa.ext.ExpressionHolder;
import lombok.RequiredArgsConstructor;

import javax.persistence.criteria.*;


@RequiredArgsConstructor
public class InSpecification<T> extends AbstractSpecification<T> {

    private final ExpressionHolder<?> expression;
    private final Object[] values;


    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        CriteriaBuilder.In in = criteriaBuilder.in(expression.getExpression(root, criteriaQuery, criteriaBuilder));

        for (Object value : values) {
            if (value instanceof Expression) {
                in.value(((ExpressionHolder<?>) value).getExpression(root, criteriaQuery, criteriaBuilder));
            } else {
                in.value(value);
            }
        }

        return in;
    }
}
