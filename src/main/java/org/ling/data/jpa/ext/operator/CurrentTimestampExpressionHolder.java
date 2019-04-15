package org.ling.data.jpa.ext.operator;

import lombok.RequiredArgsConstructor;
import org.ling.data.jpa.ext.ExpressionHolder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;

@RequiredArgsConstructor
public class CurrentTimestampExpressionHolder implements ExpressionHolder<Timestamp> {

    @Override
    public Expression<Timestamp> getExpression(Root<?> root,
                                               CriteriaQuery<?> criteriaQuery,
                                               CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.currentTimestamp();
    }
}
