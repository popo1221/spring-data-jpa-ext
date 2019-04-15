package org.ling.data.jpa.ext.operator;

import lombok.RequiredArgsConstructor;
import org.ling.data.jpa.ext.ExpressionHolder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

public abstract class ModExpressionHolder implements ExpressionHolder<Integer> {

    @RequiredArgsConstructor
    private static class ModExpressionHolder1 extends ModExpressionHolder {
        private final ExpressionHolder<Integer> x;
        private final ExpressionHolder<Integer> y;

        @Override
        public Expression<Integer> getExpression(Root<?> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.mod(x.getExpression(root, criteriaQuery, criteriaBuilder),
                    y.getExpression(root, criteriaQuery, criteriaBuilder));
        }
    }

    @RequiredArgsConstructor
    private static class ModExpressionHolder2 extends ModExpressionHolder {
        private final ExpressionHolder<Integer> x;
        private final Integer y;

        @Override
        public Expression<Integer> getExpression(Root<?> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.mod(x.getExpression(root, criteriaQuery, criteriaBuilder), y);
        }
    }

    @RequiredArgsConstructor
    private static class ModExpressionHolder3 extends ModExpressionHolder {
        private final Integer x;
        private final ExpressionHolder<Integer> y;

        @Override
        public Expression<Integer> getExpression(Root<?> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.mod(x, y.getExpression(root, criteriaQuery, criteriaBuilder));
        }
    }

    public static ModExpressionHolder create(ExpressionHolder<Integer> x, ExpressionHolder<Integer> y) {
        return new ModExpressionHolder1(x, y);
    }


    public static ModExpressionHolder create(ExpressionHolder<Integer> x, Integer y) {
        return new ModExpressionHolder2(x, y);
    }

    public static ModExpressionHolder create(Integer x, ExpressionHolder<Integer> y) {
        return new ModExpressionHolder3(x, y);
    }
}
