package br.com.lasbr.book.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("""
            SELECT book
            FROM Book book
            WHERE book.archived = false\s
            AND book.shareable = true
            AND book.owner.id != :userId\s
           \s""")
    Page<Book> findAllDisplayableBooks(Pageable pageable, Integer userId);
}
