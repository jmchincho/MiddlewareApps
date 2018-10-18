package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Variant;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface VariantService {

    Page<Variant> find(Integer index, Integer totalCount,Variant variant) throws CowException;

    Variant get(Long id) throws CowException;

    void create(Variant variant) throws CowException;

    void update(Variant variant) throws CowException;

    void delete(Long id) throws CowException;

}
