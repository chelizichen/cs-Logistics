package com.caoshuai.back.service;

import com.caoshuai.back.dto.ListRet;
import com.caoshuai.back.entity.Complaint;
import com.caoshuai.back.entity.House;
import com.caoshuai.back.repo.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    // 查询所有投诉信息
    public ListRet findAll(String keyword, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Complaint> byKeyword = complaintRepository.findByKeyword(keyword, pageable);
        List<Complaint> content = byKeyword.getContent();
        long totalElements = byKeyword.getTotalElements();
        ListRet listRet = new ListRet(content, totalElements);
        return listRet;
    }

    // 根据id查询投诉信息
    public Complaint findById(long id) {
        return complaintRepository.findById(id).orElse(null);
    }


    // 添加投诉信息
    public Complaint addComplaint(Complaint complaint) {
        complaint.setCreateTime(new Date());
        return complaintRepository.save(complaint);
    }

    // 更新投诉信息
    public Complaint updateComplaint(Complaint complaint) {
        complaint.setUpdateTime(new Date());
        return complaintRepository.save(complaint);
    }

    // 删除投诉信息
    public void deleteComplaint(long id) {
        complaintRepository.deleteById(id);
    }
}
