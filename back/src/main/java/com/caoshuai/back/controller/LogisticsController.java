package com.caoshuai.back.controller;


import com.caoshuai.back.entity.Logistics;
import com.caoshuai.back.service.LogisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//        getAllLogistics(): 获取所有物流信息
//        getLogisticsById(Long id): 根据ID获取物流信息
//        createLogistics(Logistics logistics): 创建新的物流信息
//        updateLogistics(Long id, Logistics logistics): 更新现有的物流信息
//        deleteLogistics(Long id): 删除现有的物流信息
//        updateLogisticsStatus(Long id, String status): 更新物流状态

@RestController
@RequestMapping("/logistics")
public class LogisticsController {
    @Autowired
    private LogisticsService logisticsService;

    @GetMapping
    public List<Logistics> getAllLogistics() {
        return logisticsService.getAllLogistics();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Logistics> getLogisticsById(@PathVariable Long id) {
        Optional<Logistics> optionalLogistics = logisticsService.getLogisticsById(id);
        if (optionalLogistics.isPresent()) {
            return new ResponseEntity<>(optionalLogistics.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Logistics> createLogistics(@RequestBody Logistics logistics) {
        Logistics savedLogistics = logisticsService.createLogistics(logistics);
        return new ResponseEntity<>(savedLogistics, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Logistics> updateLogistics(@PathVariable Long id, @RequestBody Logistics logistics) {
        Optional<Logistics> optionalLogistics = logisticsService.getLogisticsById(id);
        if (optionalLogistics.isPresent()) {
            Logistics updatedLogistics = logisticsService.updateLogistics(id, logistics);
            return new ResponseEntity<>(updatedLogistics, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLogistics(@PathVariable Long id) {
        Optional<Logistics> optionalLogistics = logisticsService.getLogisticsById(id);
        if (optionalLogistics.isPresent()) {
            logisticsService.deleteLogistics(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Logistics> updateLogisticsStatus(@PathVariable Long id, @RequestBody String status) {
        Optional<Logistics> optionalLogistics = logisticsService.getLogisticsById(id);
        if (optionalLogistics.isPresent()) {
            Logistics updatedLogistics = logisticsService.updateLogisticsStatus(id, status);
            return new ResponseEntity<>(updatedLogistics, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}