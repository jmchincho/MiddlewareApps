package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Provinces;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface ProvincesService {

    Page<Provinces> find(Provinces provinces) throws CowException;

    Provinces get(Long id) throws CowException;

    void create(Provinces provinces) throws CowException;

    void update(Provinces provinces) throws CowException;

    void delete(Provinces provinces) throws CowException;

}
