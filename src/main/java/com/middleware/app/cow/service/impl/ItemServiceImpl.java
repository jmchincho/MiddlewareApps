package com.middleware.app.cow.service.impl;

import com.middleware.app.cow.domain.Item;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.ItemRepository;
import com.middleware.app.cow.service.ItemService;
import com.middleware.app.cow.utils.SelectSqlBuilder;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> find(Integer page, Integer perPage, String where, String orderBy) throws CowException {
        try {
            RowBounds rowBounds = new RowBounds(page, perPage);

            String table = SelectSqlBuilder.nameTable(Item.class.getSimpleName());

            return itemRepository.findAll(table, where, orderBy, rowBounds);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public Long countAll() throws CowException {
        try {
            return itemRepository.count();
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
