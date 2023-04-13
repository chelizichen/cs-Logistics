package com.caoshuai.back.controller;

import com.caoshuai.back.dto.ListRet;
import com.caoshuai.back.dto.Ret;
import com.caoshuai.back.entity.Complaint;
import com.caoshuai.back.expection.ResourceNotFoundException;
import com.caoshuai.back.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @GetMapping("list")
    public Ret getAllComplaints(@RequestParam(value = "keyword", defaultValue = "") String keyword,
                                    @RequestParam(value = "page", defaultValue = "1") String page,
                                    @RequestParam(value = "size", defaultValue = "10") String size) {

        Integer _page = Integer.parseInt(page) - 1;
        Integer _size = Integer.valueOf(size);
        return Ret.success(complaintService.findAll(keyword,_page,_size));
    }


    @GetMapping("/one")
    public Complaint getComplaintById(@RequestParam("id") Long id) {
        return complaintService.findById(id);
    }

    @PostMapping("/update")
    public Complaint updateComplaint( @RequestBody Complaint complaintDetails) {
        if(complaintDetails.getId() != null){
            return  complaintService.updateComplaint(complaintDetails);
        }
        return complaintService.addComplaint(complaintDetails);

    }

    @GetMapping("/del")
    public ResponseEntity<?> deleteComplaint(@RequestParam("id") Long id) {
        complaintService.deleteComplaint(id);
        return ResponseEntity.ok().build();
    }
}
