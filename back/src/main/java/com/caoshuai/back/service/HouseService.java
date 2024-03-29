package com.caoshuai.back.service;

import com.caoshuai.back.dto.ListRet;
import com.caoshuai.back.entity.House;
import com.caoshuai.back.entity.User;
import com.caoshuai.back.repo.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService {

    private final HouseRepository houseRepository;

    @Autowired
    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    public ListRet findAll(String keyword, Integer page, Integer size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<House> byKeyword = houseRepository.findByKeyword(keyword, pageable);
        List<House> content = byKeyword.getContent();
        long totalElements = byKeyword.getTotalElements();
        ListRet listRet = new ListRet(content, totalElements);
        return listRet;
    }

    public House createHouse(House house) {
        return houseRepository.save(house);
    }

    public House getHouseById(Long id) {
        return houseRepository.findById(id).orElse(null);
    }

    public House updateHouse(Long id, House house) {
        House existingHouse = houseRepository.findById(id).orElse(null);
        if (existingHouse != null) {
            existingHouse.setName(house.getName());
            existingHouse.setLocation(house.getLocation());
            existingHouse.setIsOpen(house.getIsOpen());
            existingHouse.setPhone(house.getPhone());
            existingHouse.setWorkTime(house.getWorkTime());
            existingHouse.setCreateTime(house.getCreateTime());
            return houseRepository.save(existingHouse);
        }
        return null;
    }

    public void deleteHouse(Long id) {
        houseRepository.deleteById(id);
    }
}
