package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Province;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface ProvinceService {

    Page<Province> find(Integer index, Integer totalCount,Province province) throws CowException;

    Province get(Long id) throws CowException;

    void create(Province province) throws CowException;

    void update(Province province) throws CowException;

    void delete(Long id) throws CowException;

}
