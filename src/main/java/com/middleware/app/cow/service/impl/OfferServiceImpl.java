package com.middleware.app.cow.service.impl;

import com.middleware.app.cow.domain.Offer;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.OfferRepository;
import com.middleware.app.cow.service.OfferService;
import com.middleware.app.cow.utils.SelectSqlBuilder;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    private OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public List<Offer> find(Integer page, Integer perPage, String where, String orderBy) throws CowException {
        try {
            RowBounds rowBounds = new RowBounds(page, perPage);

            String table = SelectSqlBuilder.nameTable(Offer.class.getSimpleName());

            return offerRepository.findAll(table, where, orderBy, rowBounds);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public Long countAll() throws CowException {
        return null;
    }

    @Override
    public Offer get(Long id) throws CowException {
        try {
            return offerRepository.findById(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void create(Offer offer) throws CowException {
        try {
            offerRepository.insert(offer);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void update(Offer offer) throws CowException {
        try {
            offerRepository.update(offer);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void delete(Long id) throws CowException {
        try {
            offerRepository.delete(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }
}
