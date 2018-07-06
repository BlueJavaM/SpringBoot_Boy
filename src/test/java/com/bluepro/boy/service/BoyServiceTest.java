package com.bluepro.boy.service;

import com.bluepro.boy.domain.Boy;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BoyServiceTest {

    @Autowired
    private BoyService boyService;
    @Test
    public void findBoyByJjSize() {
        List<Boy> boyList = boyService.findBoyByJjSize("11cm");
        Boy boy = boyList.get(0);

       Assert.assertEquals("Tom",boy.getBoyName());

    }
}