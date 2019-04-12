package org.ling.data.jpa.ext;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class QueryExpressionRequest {

    private QueryExpression expression;

    public <T> Specification<T> toSpecification() {

        if (null == this.expression) {
            return null;
        }
        return new SpecificationBuilder<T>(this.expression).build();
    }

}
