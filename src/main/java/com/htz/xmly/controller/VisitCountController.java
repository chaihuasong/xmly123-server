package com.htz.xmly.controller;


import com.htz.xmly.entries.VisitCount;
import com.htz.xmly.repositories.VisitCountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class VisitCountController {

    @Autowired
    VisitCountRepository visitCountRepository;


    @PostMapping("/visited")
    public String saveVisitCount(String date, String type) {
        VisitCount visitCount = visitCountRepository.findByDateAndTypeEquals(date, type);
        if (visitCount != null) {
            visitCount.setCount(visitCount.getCount() + 1);
        } else {
            visitCount = new VisitCount();
            visitCount.setId(visitCountRepository.findAll().size() + "");
            visitCount.setDate(date);
            visitCount.setType(type);
            visitCount.setCount(1);
        }
        visitCountRepository.save(visitCount);

        return "success";
    }

    @GetMapping("/getVisitCount")
    public List getReportInfoById(String id) {
        return visitCountRepository.findAll();
    }
}
