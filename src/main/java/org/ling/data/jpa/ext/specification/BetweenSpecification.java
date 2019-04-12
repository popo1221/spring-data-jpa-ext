package org.ling.data.jpa.ext.specification;

import org.ling.data.jpa.ext.ExpressionHolder;
import lombok.RequiredArgsConstructor;

import javax.persistence.criteria.*;

@RequiredArgsConstructor
public class BetweenSpecification<T, P> extends AbstractSpecification<T> {

    private final ExpressionHolder<? extends Comparable> v;
    private final P x;
    private final P y;

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        Expression<? extends Comparable> vExpression = v.getExpression(root, criteriaQuery, criteriaBuilder);

        if (x instanceof ExpressionHolder && y instanceof ExpressionHolder) {
            criteriaBuilder.between(vExpression,
                    ((ExpressionHolder<? extends Comparable>) x).getExpression(root, criteriaQuery, criteriaBuilder),
                    ((ExpressionHolder<? extends Comparable>) y).getExpression(root, criteriaQuery, criteriaBuilder));
        }
        return criteriaBuilder.between(vExpression, (Comparable) x, (Comparable) y);
    }
}
