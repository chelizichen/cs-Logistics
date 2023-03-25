package com.caoshuai.back.service;

import com.caoshuai.back.entity.Warehouse;
import com.caoshuai.back.repo.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {
    @Autowired
    private WarehouseRepository warehouseRepository;

    public List<Warehouse> getAllWarehouses() {
        return warehouseRepository.findAll();
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
            existingWarehouse.setName(warehouse.getName());
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
