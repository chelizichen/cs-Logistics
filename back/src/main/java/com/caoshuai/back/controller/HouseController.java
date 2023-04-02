package com.caoshuai.back.controller;

import com.caoshuai.back.dto.Ret;
import com.caoshuai.back.entity.House;
import com.caoshuai.back.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/house")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @PostMapping
    public House createHouse(@RequestBody House house) {
        return houseService.createHouse(house);
    }

    @GetMapping
    public Ret getList(@RequestParam(value = "keyword", defaultValue = "") String keyword,
                           @RequestParam(value = "page", defaultValue = "1") String page,
                           @RequestParam(value = "size", defaultValue = "10") String size) {
        Integer _page = Integer.parseInt(page) - 1;
        Integer _size = Integer.valueOf(size);
        return Ret.success(houseService.findAll(keyword, _page, _size));
    }

    @GetMapping("/{id}")
    public House getHouseById(@PathVariable Long id) {
        return houseService.getHouseById(id);
    }

    @PutMapping("/{id}")
    public House updateHouse(@PathVariable Long id, @RequestBody House house) {
        return houseService.updateHouse(id, house);
    }

    @DeleteMapping("/{id}")
    public void deleteHouse(@PathVariable Long id) {
        houseService.deleteHouse(id);
    }
}
