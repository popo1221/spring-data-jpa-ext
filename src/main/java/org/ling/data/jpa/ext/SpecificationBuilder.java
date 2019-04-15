package org.ling.data.jpa.ext;

import org.ling.data.jpa.ext.operator.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class SpecificationBuilder<T> {

    private static final Map<String, Class<? extends Operator>> cache = new HashMap<>();

    static {
        cache.put("const", ConstOperator.class);
        cache.put("get", GetOperator.class);

        cache.put("and", AndOperator.class);
        cache.put("or", OrOperator.class);
        cache.put("not", NotOperator.class);

        cache.put("between", BetweenOperator.class);
        cache.put("greaterThan", GreaterThanOperator.class);
        cache.put("greaterThanOrEqualTo", GreaterThanOrEqualToOperator.class);
        cache.put("lessThan", LessThanOperator.class);
        cache.put("lessThanOrEqualTo", LessThanOrEqualToOperator.class);
        cache.put("equal", EqualOperator.class);
        cache.put("notEqual", NotEqualOperator.class);

        cache.put("gt", GreaterThanOperator.class);
        cache.put("ge", GreaterThanOrEqualToOperator.class);
        cache.put("lt", LessThanOperator.class);
        cache.put("le", LessThanOrEqualToOperator.class);
        cache.put("equal", EqualOperator.class);
        cache.put("notEqual", NotEqualOperator.class);


        cache.put("in", InOperator.class);

        cache.put("isNull", IsNullOperator.class);
        cache.put("isNotNull", IsNotNullOperator.class);

        cache.put("like", LikeOperator.class);
        cache.put("notLike", NotLikeOperator.class);

        // Date
        cache.put("currentDate", CurrentDateOperator.class);
        cache.put("currentTime", CurrentTimeOperator.class);
        cache.put("currentTimestamp", CurrentTimestampOperator.class);

        // Strings
        cache.put("length", LengthOperator.class);
        cache.put("lower", LowerOperator.class);
        cache.put("upper", UpperOperator.class);
        cache.put("toString", ToStringOperator.class);
        cache.put("concat", ConcatOperator.class);
        cache.put("substring", SubstringOperator.class);
        cache.put("trim", TrimOperator.class);

        // Numbers
        cache.put("abs", AbsOperator.class);
        cache.put("neg", AbsOperator.class);
        cache.put("prod", ProdOperator.class);
        cache.put("diff", DiffOperator.class);
        cache.put("quot", QuotOperator.class);
        cache.put("mod", ModOperator.class);
        cache.put("sqrt", SqrtOperator.class);
        cache.put("toBigDecimal", ToBigDecimalOperator.class);
        cache.put("toBigInteger", ToBigIntegerOperator.class);
        cache.put("toDouble", ToDoubleOperator.class);
        cache.put("toFloat", ToFloatOperator.class);
        cache.put("toInteger", ToIntegerOperator.class);
        cache.put("toLong", ToLongOperator.class);

        // Collection
        cache.put("isEmpty", IsEmptyOperator.class);
        cache.put("isNotEmpty", IsNotEmptyOperator.class);
        cache.put("size", SizeOperator.class);

    }


    static <T> Operator<T> newOperator(Class<? extends Operator> clazz, Object value, List<Operator<T>> children) {
        Constructor<? extends Operator> constructor = null;
        try {
            constructor = clazz.getConstructor(Object.class, List.class);
            return constructor.newInstance(value, children);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Create operator failed", e);
        } catch (InstantiationException e) {
            throw new RuntimeException("Create operator failed", e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Create operator failed", e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException("Create operator failed", e);
        }
    }

    @NonNull
    final QueryExpression queryExpression;

    Operator<T> buildOperator(QueryExpression queryExpression) {

        String op = queryExpression.getOperator();
        Class<? extends Operator> clazz = cache.get(op);
        if (null == clazz) {
            throw new RuntimeException("Not support operator [" + op + "]");
        }

        final List<Operator<T>> children = new ArrayList<>();
        if (null != queryExpression.getChildren()) {
            queryExpression.getChildren().forEach((child) -> children.add(buildOperator(child)));
        }

        return newOperator(clazz, queryExpression.getValue(), children);
    }


    Specification<T> build() {
        return ((SpecificationOperator<T>) buildOperator(this.queryExpression)).toSpecification();
    }

}
