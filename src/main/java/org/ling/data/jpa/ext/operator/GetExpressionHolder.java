package org.ling.data.jpa.ext.operator;

import org.ling.data.jpa.ext.ExpressionHolder;
import lombok.RequiredArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;


@RequiredArgsConstructor
public class GetExpressionHolder<T> implements ExpressionHolder<T> {

    private final String attribute;

    @Override
    public Expression<T> getExpression(Root<?> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return root.get(attribute);
    }
}
