package com.shantom.dao;

import com.shantom.pojo.Books;

import java.util.List;

public interface BooksMapper {

    int addBook(Books books);

    int deleteBookById(int id);

    int updateBook(Books books);

    Books queryBookById(int id);

    List<Books> queryAllBooks();

    List<Books> queryByName(String name);
}
