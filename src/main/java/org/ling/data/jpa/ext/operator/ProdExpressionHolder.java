package org.ling.data.jpa.ext.operator;

import lombok.RequiredArgsConstructor;
import org.ling.data.jpa.ext.ExpressionHolder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

public abstract class ProdExpressionHolder<N extends Number> implements ExpressionHolder<N> {
    @RequiredArgsConstructor
    private static class ProdExpressionHolder1<T extends Number> extends ProdExpressionHolder<T> {
        private final ExpressionHolder<? extends T> x;
        private final ExpressionHolder<? extends T> y;

        @Override
        public Expression<T> getExpression(Root<?> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.prod(x.getExpression(root, criteriaQuery, criteriaBuilder),
                    y.getExpression(root, criteriaQuery, criteriaBuilder));
        }
    }

    @RequiredArgsConstructor
    private static class ProdExpressionHolder2<T extends Number> extends ProdExpressionHolder<T> {
        private final ExpressionHolder<? extends  T> x;
        private final T y;

        @Override
        public Expression<T> getExpression(Root<?> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.prod(x.getExpression(root, criteriaQuery, criteriaBuilder), y);
        }
    }

    @RequiredArgsConstructor
    private static class ProdExpressionHolder3<T extends Number> extends ProdExpressionHolder<T> {
        private final T x;
        private final ExpressionHolder<? extends T> y;

        @Override
        public Expression<T> getExpression(Root<?> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.prod(x, y.getExpression(root, criteriaQuery, criteriaBuilder));
        }
    }

    public static <T extends Number> ProdExpressionHolder<T> create(ExpressionHolder<? extends  T> x, ExpressionHolder<? extends T> y) {
        return new ProdExpressionHolder1<>(x, y);
    }


    public static <T extends Number> ProdExpressionHolder<T> create(ExpressionHolder<? extends T> x, T y) {
        return new ProdExpressionHolder2<>(x, y);
    }

    public static <T extends Number> ProdExpressionHolder<T> create(T x, ExpressionHolder<? extends T> y) {
        return new ProdExpressionHolder3<>(x, y);
    }
}
