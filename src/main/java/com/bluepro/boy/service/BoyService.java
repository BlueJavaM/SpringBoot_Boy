package com.bluepro.boy.service;

import com.bluepro.boy.domain.Boy;
import com.bluepro.boy.enums.ExceptionEnum;
import com.bluepro.boy.exception.BoyException;
import com.bluepro.boy.repository.BoyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
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

    public void getAge(Integer id) throws Exception{
        Boy boy = boyRepository.findOne(id);
        Integer age = boy.getAge();
        if (age <= 12){
            throw new BoyException(ExceptionEnum.LITTLE_BOY.getCode(),ExceptionEnum.LITTLE_BOY.getMsg());
        }else if(age > 12 && age <= 40){
            throw new BoyException(ExceptionEnum.MAN.getCode(),ExceptionEnum.MAN.getMsg());
        }else if(age > 40 && age <= 60){
            throw new BoyException(ExceptionEnum.OLD_MAN.getCode(),ExceptionEnum.OLD_MAN.getMsg());
        }
    }
}
