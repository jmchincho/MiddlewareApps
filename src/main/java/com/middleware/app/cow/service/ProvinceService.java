package com.middleware.app.cow.service;

import java.util.List;
import com.middleware.app.cow.domain.Province;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface ProvinceService {

    List<Province> find(Integer page, Integer perPage, String where, String orderBy) throws CowException;

    Long countAll() throws CowException;

    Province get(Long id) throws CowException;

    void create(Province province) throws CowException;

    void update(Province province) throws CowException;

    void delete(Long id) throws CowException;

}
