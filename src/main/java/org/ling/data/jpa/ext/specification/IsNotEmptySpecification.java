package org.ling.data.jpa.ext.specification;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.ling.data.jpa.ext.ExpressionHolder;

import javax.persistence.criteria.*;
import java.util.Collection;

@RequiredArgsConstructor
public class IsNotEmptySpecification<T> extends AbstractSpecification<T> {

    @NonNull
    private final ExpressionHolder<? extends Collection<?>> x;

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        Expression<? extends Collection<?>> xExpression = x.getExpression(root, criteriaQuery, criteriaBuilder);
        return criteriaBuilder.isNotEmpty(xExpression);
    }
}
