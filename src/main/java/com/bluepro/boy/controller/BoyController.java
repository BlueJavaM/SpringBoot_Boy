package com.bluepro.boy.controller;

import com.bluepro.boy.domain.Boy;
import com.bluepro.boy.domain.Result;
import com.bluepro.boy.enums.ExceptionEnum;
import com.bluepro.boy.repository.BoyRepository;
import com.bluepro.boy.service.BoyService;
import com.bluepro.boy.util.BoyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
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
    @Autowired
    private BoyUtil boyUtil;

    @GetMapping(value = "/boys")
    public List<Boy> findAllBoy(){
        return boyRepository.findAll();
    }

    @GetMapping(value = "/boys/{id}")
    public Boy findBoyByID(@PathVariable("id") Integer id){
        return boyRepository.findOne(id);
    }

    @PostMapping(value = "/boys")
    public Object addBoy(@Valid Boy boy, BindingResult bindingResult){
        //若不满足实体类Boy设置验证
        if(bindingResult.hasErrors()){
            return boyUtil.error(ExceptionEnum.ERROR.getCode(),ExceptionEnum.ERROR.getMsg());
        }
        return boyUtil.success(boyRepository.save(boy));
    }

    @PutMapping(value = "/boys/{id}")
    public Boy updateBoy(@PathVariable("id") Integer id,
                         Boy boy){
        boy.setId(id);
        boy.setBoyName(boy.getBoyName());
        boy.setAge(boy.getAge());
        boy.setJjSize(boy.getJjSize());
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

    @GetMapping(value = "/boys/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
         boyService.getAge(id);
    }
}
