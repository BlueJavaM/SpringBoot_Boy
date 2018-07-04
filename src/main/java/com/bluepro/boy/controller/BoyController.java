package com.bluepro.boy.controller;

import com.bluepro.boy.domain.Boy;
import com.bluepro.boy.repository.BoyRepository;
import com.bluepro.boy.service.BoyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 *@Author: XieLiang
 *@Date : 2018/7/4
 *@Comment :
 */
@RestController
public class BoyController {
    @Autowired
    private BoyRepository boyRepository;

    @Autowired
    private BoyService boyService;

    @GetMapping(value = "/boys")
    public List<Boy> findAllBoy(){
        return boyRepository.findAll();
    }

    @GetMapping(value = "/boys/{id}")
    public Boy findBoyByID(@PathVariable("id") Integer id){
        return boyRepository.findOne(id);
    }

    @PostMapping(value = "/boys")
    public Boy addBoy(@RequestParam("name") String boyName,
                      @RequestParam("age") int age,
                      @RequestParam("size") String jjSize){
        Boy boy = new Boy();
        boy.setBoyName(boyName);
        boy.setAge(age);
        boy.setJjSize(jjSize);
        return boyRepository.save(boy);
    }

    @PutMapping(value = "/boys/{id}")
    public Boy updateBoy(@PathVariable("id") Integer id,
                         @RequestParam("name") String boyName,
                         @RequestParam("age") int age,
                         @RequestParam("size") String jjSize){
        Boy boy = new Boy();
        boy.setId(id);
        boy.setBoyName(boyName);
        boy.setAge(age);
        boy.setJjSize(jjSize);
        return  boyRepository.save(boy);
    }

    @DeleteMapping(value = "/boys/{id}")
    public void deleteBoy(@PathVariable("id") Integer id){
        boyRepository.delete(id);
    }

    @GetMapping(value = "/boys/size/{size}")
    public List<Boy> findBoyByJjSize(@PathVariable("size") String jjSize){
        return boyService.findBoyByJjSize(jjSize);
    }
}
