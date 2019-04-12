package org.ling.data.jpa.ext.operator;

import org.ling.data.jpa.ext.ExpressionHolder;
import lombok.RequiredArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

@RequiredArgsConstructor
public class LengthExpressionHolder implements ExpressionHolder<Integer> {

    private final ExpressionHolder<String> prev;

    @Override
    public Expression<Integer> getExpression(Root<?> root,
                                             CriteriaQuery<?> criteriaQuery,
                                             CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.length(prev.getExpression(root, criteriaQuery, criteriaBuilder));
    }
}
