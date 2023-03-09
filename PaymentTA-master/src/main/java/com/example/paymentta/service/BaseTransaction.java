package com.example.paymentta.service;

import com.example.paymentta.exceptions.ServiceException;

public interface BaseTransaction<D> {
    public void resolveTransaction(D d) throws ServiceException;
}
