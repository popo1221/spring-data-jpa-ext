package org.ling.data.jpa.ext.specification;

import org.ling.data.jpa.ext.ExpressionHolder;
import lombok.RequiredArgsConstructor;

import javax.persistence.criteria.*;

@RequiredArgsConstructor
public class LessThanOrEqualToSpecification<T, P> extends AbstractSpecification<T> {

    private final ExpressionHolder<? extends Comparable> x;
    private final P y;

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        Expression<? extends Comparable> xExpression = x.getExpression(root, criteriaQuery, criteriaBuilder);
        if (y instanceof Expression) {
            return criteriaBuilder.lessThanOrEqualTo(xExpression,
                    ((ExpressionHolder<Comparable>) y).getExpression(root, criteriaQuery, criteriaBuilder));
        }

        return criteriaBuilder.lessThanOrEqualTo(xExpression, (Comparable) y);
    }
}
