package com.caoshuai.back.repo;


import com.caoshuai.back.entity.Logistics;
import com.caoshuai.back.entity.Warehouse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LogisticsRepository extends JpaRepository<Logistics, Long> {
    @Query("SELECT l FROM Logistics l,User u where l.userId = u.id and l.userId = ?1")
    Page<Logistics> getAllByUserId(Long id, Pageable pageable);
}
