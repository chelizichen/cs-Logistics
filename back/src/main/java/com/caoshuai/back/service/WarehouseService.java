package com.caoshuai.back.service;

import com.caoshuai.back.dto.ListRet;
import com.caoshuai.back.entity.User;
import com.caoshuai.back.entity.Warehouse;
import com.caoshuai.back.repo.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {
    @Autowired
    private WarehouseRepository warehouseRepository;

    public ListRet getAllWarehouses(String keyword,Integer page,Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Warehouse> byKeyword = warehouseRepository.getAllByKeyWord(keyword, pageable);
        List<Warehouse> all = warehouseRepository.findAll();
        List<Warehouse> content = byKeyword.getContent();
        long totalElements = byKeyword.getTotalElements();
        ListRet listRet = new ListRet(content, totalElements);
        return listRet;
    }

    public Optional<Warehouse> getWarehouseById(Long id) {
        return warehouseRepository.findById(id);
    }

    public Warehouse createWarehouse(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    public Warehouse updateWarehouse(Long id, Warehouse warehouse) {
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);
        if (optionalWarehouse.isPresent()) {
            Warehouse existingWarehouse = optionalWarehouse.get();
            existingWarehouse.setOrderId(warehouse.getOrderId());
            existingWarehouse.setAddress(warehouse.getAddress());
            existingWarehouse.setInTime(warehouse.getInTime());
            existingWarehouse.setOutTime(warehouse.getOutTime());
            return warehouseRepository.save(existingWarehouse);
        } else {
            return null;
        }
    }

    public void deleteWarehouse(Long id) {
        warehouseRepository.deleteById(id);
    }
}
