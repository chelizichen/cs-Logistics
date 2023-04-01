package com.caoshuai.back.repo;

import com.caoshuai.back.entity.Order;
import com.caoshuai.back.entity.Warehouse;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

    @Query("SELECT w FROM Warehouse w,House h where w.houseId = h.id and h.name like %?1% ")
    Page<Warehouse> getAllByKeyWord(String keyword,Pageable pageable);
}
