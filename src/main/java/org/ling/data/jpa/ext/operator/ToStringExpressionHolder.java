package org.ling.data.jpa.ext.operator;

import lombok.RequiredArgsConstructor;
import org.ling.data.jpa.ext.ExpressionHolder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;

@RequiredArgsConstructor
public class ToStringExpressionHolder implements ExpressionHolder<String> {

    private final ExpressionHolder<Character> x;

    @Override
    public Expression<String> getExpression(Root<?> root,
                                                CriteriaQuery<?> criteriaQuery,
                                                CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.toString(x.getExpression(root, criteriaQuery, criteriaBuilder));
    }
}
