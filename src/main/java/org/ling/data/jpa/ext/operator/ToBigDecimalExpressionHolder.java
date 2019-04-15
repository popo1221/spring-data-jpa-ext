package org.ling.data.jpa.ext.operator;

import lombok.RequiredArgsConstructor;
import org.ling.data.jpa.ext.ExpressionHolder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;

@RequiredArgsConstructor
public class ToBigDecimalExpressionHolder implements ExpressionHolder<BigDecimal> {

    private final ExpressionHolder<? extends Number> x;

    @Override
    public Expression<BigDecimal> getExpression(Root<?> root,
                                                CriteriaQuery<?> criteriaQuery,
                                                CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.toBigDecimal(x.getExpression(root, criteriaQuery, criteriaBuilder));
    }
}
