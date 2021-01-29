package com.shantom.service;

import com.shantom.dao.BooksMapper;
import com.shantom.pojo.Books;
import org.junit.Test;

import java.util.List;

public class BookServiceImpl implements BookService{
    private BooksMapper booksMapper;

    public void setBooksMapper(BooksMapper booksMapper) {
        this.booksMapper = booksMapper;
    }

    @Override
    public int addBook(Books books) {
        return booksMapper.addBook(books);
    }

    @Override
    public int deleteBookById(int id) {
        return booksMapper.deleteBookById(id);
    }

    @Override
    public int updateBook(Books books) {
        return booksMapper.updateBook(books);
    }

    @Override
    public Books queryBookById(int id) {
        return booksMapper.queryBookById(id);
    }

    @Override
    public List<Books> queryAllBooks() {
        return booksMapper.queryAllBooks();
    }

    @Override
    public List<Books> queryBooksByName(String name) {
        name = "'%"+name+"%'";
        return booksMapper.queryByName(name);
    }


}
