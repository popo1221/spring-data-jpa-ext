package org.ling.data.jpa.ext.operator;

import lombok.RequiredArgsConstructor;
import org.ling.data.jpa.ext.ExpressionHolder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.Collection;

public abstract class SizeExpressionHolder implements ExpressionHolder<Integer> {
    @RequiredArgsConstructor
    private static class SizeExpressionHolder1 extends SizeExpressionHolder {
        private final ExpressionHolder<? extends Collection<?>> x;

        @Override
        public Expression<Integer> getExpression(Root<?> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.size(x.getExpression(root, criteriaQuery, criteriaBuilder));
        }
    }

    @RequiredArgsConstructor
    private static class SizeExpressionHolder2 extends SizeExpressionHolder {
        private final Collection<?> x;

        @Override
        public Expression<Integer> getExpression(Root<?> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.size(x);
        }
    }

    public static SizeExpressionHolder create(Collection<?> x) {
        return new SizeExpressionHolder2(x);
    }


    public static SizeExpressionHolder create(ExpressionHolder<? extends Collection<?>> x) {
        return new SizeExpressionHolder1(x);
    }
}
