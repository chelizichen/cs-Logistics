package com.caoshuai.back.service;


import com.caoshuai.back.entity.Logistics;
import com.caoshuai.back.repo.LogisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LogisticsService {
    @Autowired
    private LogisticsRepository logisticsRepository;

    public List<Logistics> getAllLogistics() {
        return logisticsRepository.findAll();
    }

    public Optional<Logistics> getLogisticsById(Long id) {
        return logisticsRepository.findById(id);
    }

    public Logistics createLogistics(Logistics logistics) {
        return logisticsRepository.save(logistics);
    }

    public Logistics updateLogistics(Long id, Logistics logistics) {
        logistics.setId(id);
        return logisticsRepository.save(logistics);
    }

    public void deleteLogistics(Long id) {
        logisticsRepository.deleteById(id);
    }

    public Logistics updateLogisticsStatus(Long id, String status) {
        Optional<Logistics> optionalLogistics = logisticsRepository.findById(id);
        if (optionalLogistics.isPresent()) {
            Logistics logistics = optionalLogistics.get();
            logistics.setLogisticsStatus(status);
            return logisticsRepository.save(logistics);
        } else {
            return null;
        }
    }
}
