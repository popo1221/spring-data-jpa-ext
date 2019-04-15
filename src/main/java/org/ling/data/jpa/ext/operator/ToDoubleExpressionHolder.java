package org.ling.data.jpa.ext.operator;

import lombok.RequiredArgsConstructor;
import org.ling.data.jpa.ext.ExpressionHolder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

@RequiredArgsConstructor
public class ToDoubleExpressionHolder implements ExpressionHolder<Double> {

    private final ExpressionHolder<? extends Number> x;

    @Override
    public Expression<Double> getExpression(Root<?> root,
                                             CriteriaQuery<?> criteriaQuery,
                                             CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.toDouble(x.getExpression(root, criteriaQuery, criteriaBuilder));
    }
}
