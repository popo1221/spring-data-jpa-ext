package org.ling.data.jpa.ext;

public interface OperatorFactory {

    <T> T newOperator(QueryExpression expression);

}
