package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Offer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OfferRepository {

    Page<Offer> findAll(Offer offer) throws Exception;

    Offer findById(Long id) throws Exception;

    void insert(Offer offer) throws Exception;

    void update(Offer offer) throws Exception;

    void delete(Long id) throws Exception;

}