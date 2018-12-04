package com.middleware.app.cow.service;


import java.util.List;
import com.middleware.app.cow.domain.Subcription;
import com.middleware.app.cow.exceptions.CowException;

public interface SubcriptionService {

    List<Subcription> find(Integer page, Integer perPage, String where, String orderBy) throws CowException;

    Subcription get(Long id) throws CowException;

    void create(Subcription subcription) throws CowException;

    void update(Subcription subcription) throws CowException;

    void delete(Long id) throws CowException;

}
