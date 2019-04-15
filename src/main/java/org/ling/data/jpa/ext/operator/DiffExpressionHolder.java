package org.ling.data.jpa.ext.operator;

import lombok.RequiredArgsConstructor;
import org.ling.data.jpa.ext.ExpressionHolder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

public abstract class DiffExpressionHolder<N extends Number> implements ExpressionHolder<N> {
    @RequiredArgsConstructor
    private static class DiffExpressionHolder1<T extends Number> extends DiffExpressionHolder<T> {
        private final ExpressionHolder<? extends T> x;
        private final ExpressionHolder<? extends T> y;

        @Override
        public Expression<T> getExpression(Root<?> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.diff(x.getExpression(root, criteriaQuery, criteriaBuilder),
                    y.getExpression(root, criteriaQuery, criteriaBuilder));
        }
    }

    @RequiredArgsConstructor
    private static class DiffExpressionHolder2<T extends Number> extends DiffExpressionHolder<T> {
        private final ExpressionHolder<? extends  T> x;
        private final T y;

        @Override
        public Expression<T> getExpression(Root<?> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.diff(x.getExpression(root, criteriaQuery, criteriaBuilder), y);
        }
    }

    @RequiredArgsConstructor
    private static class DiffExpressionHolder3<T extends Number> extends DiffExpressionHolder<T> {
        private final T x;
        private final ExpressionHolder<? extends T> y;

        @Override
        public Expression<T> getExpression(Root<?> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.diff(x, y.getExpression(root, criteriaQuery, criteriaBuilder));
        }
    }

    public static <T extends Number> DiffExpressionHolder<T> create(ExpressionHolder<? extends  T> x, ExpressionHolder<? extends T> y) {
        return new DiffExpressionHolder1<>(x, y);
    }


    public static <T extends Number> DiffExpressionHolder<T> create(ExpressionHolder<? extends T> x, T y) {
        return new DiffExpressionHolder2<>(x, y);
    }

    public static <T extends Number> DiffExpressionHolder<T> create(T x, ExpressionHolder<? extends T> y) {
        return new DiffExpressionHolder3<>(x, y);
    }
}
