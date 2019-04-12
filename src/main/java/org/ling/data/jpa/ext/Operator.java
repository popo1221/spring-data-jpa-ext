package org.ling.data.jpa.ext;

import java.util.Collections;
import java.util.List;

public interface Operator<T> {
    default List<Operator<T>> getChildren() {
        return Collections.emptyList();
    }
}
