package org.ling.data.jpa.ext.operator;

import lombok.RequiredArgsConstructor;
import org.ling.data.jpa.ext.ExpressionHolder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

@RequiredArgsConstructor
public class ToLongExpressionHolder implements ExpressionHolder<Long> {

    private final ExpressionHolder<? extends Number> x;

    @Override
    public Expression<Long> getExpression(Root<?> root,
                                             CriteriaQuery<?> criteriaQuery,
                                             CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.toLong(x.getExpression(root, criteriaQuery, criteriaBuilder));
    }
}
