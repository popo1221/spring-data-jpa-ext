package org.ling.data.jpa.ext;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

public interface ExpressionHolder<T> {
    Expression<T> getExpression(Root<?> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder);

}
