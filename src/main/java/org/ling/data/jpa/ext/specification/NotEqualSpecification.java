package org.ling.data.jpa.ext.specification;

import org.ling.data.jpa.ext.ExpressionHolder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.criteria.*;

@RequiredArgsConstructor
public class NotEqualSpecification<T> extends AbstractSpecification<T> {

    @NonNull
    private final ExpressionHolder<?> x;
    @NonNull
    private final Object y;

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        Expression<?> xExpression = x.getExpression(root, criteriaQuery, criteriaBuilder);
        if (y instanceof Expression) {
            return criteriaBuilder.notEqual(xExpression,
                    ((ExpressionHolder<?>) y).getExpression(root, criteriaQuery, criteriaBuilder));
        }

        return criteriaBuilder.notEqual(xExpression, y);
    }
}
