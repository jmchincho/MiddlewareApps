package com.middleware.app.cow.service;

import java.util.List;
import com.middleware.app.cow.domain.Variant;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface VariantService {

    List<Variant> find(Integer page, Integer perPage, String where, String orderBy) throws CowException;

    Variant get(Long id) throws CowException;

    void create(Variant variant) throws CowException;

    void update(Variant variant) throws CowException;

    void delete(Long id) throws CowException;

}
