package com.caoshuai.back.repo;

import com.caoshuai.back.entity.House;
import com.caoshuai.back.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {
    @Query("SELECT h FROM  House h  WHERE h.name LIKE %?1%")
    Page<House> findByKeyword(String keyword, Pageable pageable);
}