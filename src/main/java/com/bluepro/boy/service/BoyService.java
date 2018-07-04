package com.bluepro.boy.service;

import com.bluepro.boy.domain.Boy;
import com.bluepro.boy.repository.BoyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/*
 *@Author: XieLiang
 *@Date : 2018/7/4
 *@Comment :
 */
@Service
public class BoyService {
    @Autowired
    private BoyRepository boyRepository;


    public List<Boy> findBoyByJjSize(String jjSize){
        return boyRepository.findBoyByJjSize(jjSize);
    }
}
