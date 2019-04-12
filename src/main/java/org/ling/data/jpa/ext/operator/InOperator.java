package org.ling.data.jpa.ext.operator;

import org.ling.data.jpa.ext.Operator;
import org.ling.data.jpa.ext.specification.InSpecification;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class InOperator<T> extends AbstractOperator<T>  implements SpecificationOperator<T>{
    public InOperator(Object value, List<Operator<T>> children) {
        super(value, children);
    }

    @Override
    public Specification<T> toSpecification() {

        List<Operator<T>> operators = children.subList(1, children.size());
        List<Object> values = new ArrayList();
        for(Operator<T> operator : operators) {
            values.add(getObjectOrExpression(operator));
        }

        return new InSpecification<>(getObjectOrExpression(children.get(0)), values.toArray());
    }
}
