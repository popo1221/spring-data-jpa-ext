package org.ling.data.jpa.ext.specification;

import org.ling.data.jpa.ext.ExpressionHolder;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.criteria.*;

@AllArgsConstructor
@RequiredArgsConstructor
public class LikeSpecification<T, P> extends AbstractSpecification<T> {

    @NonNull
    private final ExpressionHolder<String> x;
    @NonNull
    private final P pattern;

    private Character escapeChar;

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {


        Expression<String> xExpression = x.getExpression(root, criteriaQuery, criteriaBuilder);
        if (this.pattern instanceof Expression) {
            return criteriaBuilder.like(xExpression,
                    ((ExpressionHolder<String>) pattern).getExpression(root, criteriaQuery, criteriaBuilder));
        }

        return criteriaBuilder.like(xExpression, (String) pattern);
    }
}
