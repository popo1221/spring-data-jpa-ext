package org.ling.data.jpa.ext.specification;

import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;

public abstract class AbstractSpecification<T> implements Specification<T>, Serializable {

}
