package org.backend1.que4;

import java.util.Comparator;

public class PubDateAscComparator implements Comparator<Book> {
    public int compare(Book book1, Book book2)
    {
        int bookComparison = Integer.compare(book1.getYear(), book2.getYear());
        if(bookComparison == 0){
            return book1.getTitle().compareTo(book2.getTitle());
        }
        return bookComparison;
    }

}