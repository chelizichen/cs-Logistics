package com.caoshuai.back.controller;


import com.caoshuai.back.entity.Warehouse;
import com.caoshuai.back.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/warehouses")
public class WarehouseController {
    @Autowired
    private WarehouseService warehouseService;

    @GetMapping
    public List<Warehouse> getAllWarehouses() {
        return warehouseService.getAllWarehouses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Warehouse> getWarehouseById(@PathVariable Long id) {
        Optional<Warehouse> optionalWarehouse = warehouseService.getWarehouseById(id);
        if (optionalWarehouse.isPresent()) {
            Warehouse warehouse = optionalWarehouse.get();
            return new ResponseEntity<>(warehouse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Warehouse> createWarehouse(@RequestBody Warehouse warehouse) {
        Warehouse createdWarehouse = warehouseService.createWarehouse(warehouse);
        return new ResponseEntity<>(createdWarehouse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Warehouse> updateWarehouse(@PathVariable Long id, @RequestBody Warehouse warehouse) {
        Warehouse updatedWarehouse = warehouseService.updateWarehouse(id, warehouse);
        if (updatedWarehouse != null) {
            return new ResponseEntity<>(updatedWarehouse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWarehouse(@PathVariable Long id) {
        warehouseService.deleteWarehouse(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
