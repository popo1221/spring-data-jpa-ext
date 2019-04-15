package org.ling.data.jpa.ext.operator;

import lombok.RequiredArgsConstructor;
import org.ling.data.jpa.ext.ExpressionHolder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

public abstract class QuotExpressionHolder implements ExpressionHolder<Number> {

    @RequiredArgsConstructor
    private static class QuotExpressionHolder1 extends QuotExpressionHolder {
        private final ExpressionHolder<? extends Number> x;
        private final ExpressionHolder<? extends Number> y;

        @Override
        public Expression<Number> getExpression(Root<?> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.quot(x.getExpression(root, criteriaQuery, criteriaBuilder),
                    y.getExpression(root, criteriaQuery, criteriaBuilder));
        }
    }

    @RequiredArgsConstructor
    private static class QuotExpressionHolder2 extends QuotExpressionHolder {
        private final ExpressionHolder<? extends Number> x;
        private final Number y;

        @Override
        public Expression<Number> getExpression(Root<?> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.prod(x.getExpression(root, criteriaQuery, criteriaBuilder), y);
        }
    }

    @RequiredArgsConstructor
    private static class QuotExpressionHolder3 extends QuotExpressionHolder {
        private final Number x;
        private final ExpressionHolder<? extends Number> y;

        @Override
        public Expression<Number> getExpression(Root<?> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.prod(x, y.getExpression(root, criteriaQuery, criteriaBuilder));
        }
    }

    public static <T extends Number> QuotExpressionHolder create(ExpressionHolder<? extends T> x, ExpressionHolder<? extends T> y) {
        return new QuotExpressionHolder1(x, y);
    }


    public static <T extends Number> QuotExpressionHolder create(ExpressionHolder<? extends T> x, T y) {
        return new QuotExpressionHolder2(x, y);
    }

    public static <T extends Number> QuotExpressionHolder create(T x, ExpressionHolder<? extends T> y) {
        return new QuotExpressionHolder3(x, y);
    }
}
