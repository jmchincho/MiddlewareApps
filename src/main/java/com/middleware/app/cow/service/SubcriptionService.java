package com.middleware.app.cow.service;


import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Subcription;
import com.middleware.app.cow.exceptions.CowException;

public interface SubcriptionService {

    Page<Subcription> find(Subcription subcription) throws CowException;

    Subcription get(Long id) throws CowException;

    void create(Subcription subcription) throws CowException;

    void update(Subcription subcription) throws CowException;

    void delete(Subcription subcription) throws CowException;

}
