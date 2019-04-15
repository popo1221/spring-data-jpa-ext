package org.ling.data.jpa.ext.operator;

import lombok.RequiredArgsConstructor;
import org.ling.data.jpa.ext.ExpressionHolder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

public abstract class ConcatExpressionHolder implements ExpressionHolder<String> {

    @RequiredArgsConstructor
    private static class ConcatExpressionHolder1 extends ConcatExpressionHolder {
        private final ExpressionHolder<String> x;
        private final ExpressionHolder<String> y;

        @Override
        public Expression<String> getExpression(Root<?> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.concat(x.getExpression(root, criteriaQuery, criteriaBuilder),
                    y.getExpression(root, criteriaQuery, criteriaBuilder));
        }
    }

    @RequiredArgsConstructor
    private static class ConcatExpressionHolder2 extends ConcatExpressionHolder {
        private final ExpressionHolder<String> x;
        private final String y;

        @Override
        public Expression<String> getExpression(Root<?> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.concat(x.getExpression(root, criteriaQuery, criteriaBuilder), y);
        }
    }

    @RequiredArgsConstructor
    private static class ConcatExpressionHolder3 extends ConcatExpressionHolder {
        private final String x;
        private final ExpressionHolder<String> y;

        @Override
        public Expression<String> getExpression(Root<?> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.concat(x, y.getExpression(root, criteriaQuery, criteriaBuilder));
        }
    }

    public static ConcatExpressionHolder create(ExpressionHolder<String> x, ExpressionHolder<String> y) {
        return new ConcatExpressionHolder1(x, y);
    }


    public static ConcatExpressionHolder create(ExpressionHolder<String> x, String y) {
        return new ConcatExpressionHolder2(x, y);
    }

    public static ConcatExpressionHolder create(String x, ExpressionHolder<String> y) {
        return new ConcatExpressionHolder3(x, y);
    }
}
