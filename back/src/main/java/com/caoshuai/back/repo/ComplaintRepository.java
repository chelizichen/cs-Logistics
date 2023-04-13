package com.caoshuai.back.repo;

import com.caoshuai.back.entity.Complaint;
import com.caoshuai.back.entity.House;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

    @Query("SELECT h FROM  Complaint  h WHERE h.user.name LIKE %?1%")
    Page<Complaint> findByKeyword(String keyword, Pageable pageable);

}
