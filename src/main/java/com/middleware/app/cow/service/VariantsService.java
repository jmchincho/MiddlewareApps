package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Variants;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface VariantsService {

    Page<Variants> find(Variants variants) throws CowException;

    Variants get(Long id) throws CowException;

    void create(Variants variants) throws CowException;

    void update(Variants variants) throws CowException;

    void delete(Variants variants) throws CowException;

}
