package com.caoshuai.back.controller;


import com.caoshuai.back.dto.Ret;
import com.caoshuai.back.entity.Logistics;
import com.caoshuai.back.service.LogisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public Ret getAllLogistics(@RequestParam(value = "keyword", defaultValue = "") String keyword,
                                           @RequestParam(value = "page", defaultValue = "1") String page,
                                           @RequestParam(value = "size", defaultValue = "10") String size) {
        Integer _page = Integer.parseInt(page) - 1;
        Integer _size = Integer.valueOf(size);

        return Ret.success(logisticsService.getAllLogistics(keyword,_page,_size));
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
            System.out.println(logistics.getLogisticsStatus());
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

    // 手机端
    @GetMapping("/getUserById")
    public Ret getByUserId(@RequestParam(value = "id", defaultValue = "1") String id,
                           @RequestParam(value = "page", defaultValue = "1") String page,
                           @RequestParam(value = "size", defaultValue = "10") String size) {
        Long _id = Long.parseLong(id);
        Integer _page = Integer.parseInt(page) - 1;
        Integer _size = Integer.valueOf(size);
        return Ret.success(logisticsService.getByUserId(_id, _page, _size));
    }
}
