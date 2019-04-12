package org.ling.data.jpa.ext;

import lombok.Data;

@Data
public class QueryExpression {

    private String operator;

    private Object value;

    private Iterable<QueryExpression> children;

}
