package com.caoshuai.back.repo;


import com.caoshuai.back.entity.Logistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogisticsRepository extends JpaRepository<Logistics, Long> {
}
