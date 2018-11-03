package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.middleware.app.cow.domain.Item;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.ItemRepository;
import com.middleware.app.cow.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Page<Item> find(Integer index, Integer totalCount,Item item) throws CowException {
        try {
            PageHelper.offsetPage(index, totalCount);
            return itemRepository.findAll(item);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public Item get(Long id) throws CowException {
        try {
            return itemRepository.findById(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void create(Item item) throws CowException {
        try {
            itemRepository.insert(item);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void update(Item item) throws CowException {
        try {
            itemRepository.update(item);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void delete(Long id) throws CowException {
        try {
            itemRepository.delete(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }
}
