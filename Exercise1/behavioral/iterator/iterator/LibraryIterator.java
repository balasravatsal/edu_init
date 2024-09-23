
package com.designpatterns.iterator.iterator;

import com.designpatterns.iterator.model.Book;

public interface LibraryIterator {
    boolean hasNext();

    Book next();
}
