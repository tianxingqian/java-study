package com.mashibing.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MulService {
    @Autowired
    private BookService bookService;

    @Transactional
    public void mulTx(){
        try {
            bookService.checkout("zhangsan",1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        bookService.updatePrice(1);
        int i = 1/0;
    }
}
