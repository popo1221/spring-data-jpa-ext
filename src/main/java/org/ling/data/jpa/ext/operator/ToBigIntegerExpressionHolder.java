package org.ling.data.jpa.ext.operator;

import lombok.RequiredArgsConstructor;
import org.ling.data.jpa.ext.ExpressionHolder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.math.BigInteger;

@RequiredArgsConstructor
public class ToBigIntegerExpressionHolder implements ExpressionHolder<BigInteger> {

    private final ExpressionHolder<? extends Number> x;

    @Override
    public Expression<BigInteger> getExpression(Root<?> root,
                                                CriteriaQuery<?> criteriaQuery,
                                                CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.toBigInteger(x.getExpression(root, criteriaQuery, criteriaBuilder));
    }
}
