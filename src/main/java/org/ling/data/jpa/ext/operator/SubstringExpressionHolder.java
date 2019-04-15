package org.ling.data.jpa.ext.operator;

import lombok.RequiredArgsConstructor;
import org.ling.data.jpa.ext.ExpressionHolder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

public abstract class SubstringExpressionHolder implements ExpressionHolder<String> {

    @RequiredArgsConstructor
    private static class SubstringExpressionHolder1 extends SubstringExpressionHolder {
        private final ExpressionHolder<String> x;
        private final ExpressionHolder<Integer> from;

        @Override
        public Expression<String> getExpression(Root<?> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.substring(x.getExpression(root, criteriaQuery, criteriaBuilder),
                    from.getExpression(root, criteriaQuery, criteriaBuilder));
        }
    }

    @RequiredArgsConstructor
    private static class SubstringExpressionHolder2 extends SubstringExpressionHolder {
        private final ExpressionHolder<String> x;
        private final Integer from;

        @Override
        public Expression<String> getExpression(Root<?> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.substring(x.getExpression(root, criteriaQuery, criteriaBuilder), from);
        }
    }

    @RequiredArgsConstructor
    private static class SubstringExpressionHolder3 extends SubstringExpressionHolder {
        private final ExpressionHolder<String> x;
        private final ExpressionHolder<Integer> from;
        private final ExpressionHolder<Integer> len;

        @Override
        public Expression<String> getExpression(Root<?> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.substring(
                    x.getExpression(root, criteriaQuery, criteriaBuilder),
                    from.getExpression(root, criteriaQuery, criteriaBuilder),
                    len.getExpression(root, criteriaQuery, criteriaBuilder));
        }
    }

    @RequiredArgsConstructor
    private static class SubstringExpressionHolder4 extends SubstringExpressionHolder {
        private final ExpressionHolder<String> x;
        private final Integer from;
        private final Integer len;

        @Override
        public Expression<String> getExpression(Root<?> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.substring(x.getExpression(root, criteriaQuery, criteriaBuilder), from, len);
        }
    }

    public static SubstringExpressionHolder create(ExpressionHolder<String> x, ExpressionHolder<Integer> from) {
        return new SubstringExpressionHolder1(x, from);
    }


    public static SubstringExpressionHolder create(ExpressionHolder<String> x, Integer from) {
        return new SubstringExpressionHolder2(x, from);
    }

    public static SubstringExpressionHolder create(ExpressionHolder<String> x, ExpressionHolder<Integer> from, ExpressionHolder<Integer> len) {
        return new SubstringExpressionHolder3(x, from, len);
    }


    public static SubstringExpressionHolder create(ExpressionHolder<String> x, Integer from, Integer len) {
        return new SubstringExpressionHolder4(x, from, len);
    }
}
