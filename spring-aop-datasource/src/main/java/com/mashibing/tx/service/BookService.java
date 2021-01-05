package com.mashibing.tx.service;

import com.mashibing.tx.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Service
public class BookService {

    @Autowired
    BookDao bookDao;

    /**
     * 结账：传入哪个用户买了哪本书
     *
     * @param username
     * @param id
     */
    // @Transactional(timeout = 4, readOnly = true)
    // @Transactional(timeout = 4, noRollbackFor = {ArithmeticException.class, NullPointerException.class})
    // @Transactional(timeout = 4, noRollbackForClassName = {"java.lang.ArithmeticException"})
    // @Transactional(timeout = 4, rollbackFor = {FileNotFoundException.class})
    // @Transactional(timeout = 4, isolation = Isolation.READ_COMMITTED)
    @Transactional (propagation = Propagation.NESTED)
    public void checkout(String username, int id) {

        bookDao.updateStock(id);
        int price = bookDao.getPrice(id);
        bookDao.updateBalance(username, price);
        // int i = 1/0;
        // new FileInputStream("aaa.txt");
    }


    @Transactional (propagation = Propagation.REQUIRES_NEW)
    public void updatePrice(int id) {
        bookDao.updatePrice(id);
        // int i = 1/0;
    }
}
