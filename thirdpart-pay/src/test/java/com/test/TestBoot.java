package com.test;

import com.test.serivce.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xiaofengfu on 2017/6/6.
 */
@SpringBootTest(classes = SpringBootDemo.class)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootConfiguration
public class TestBoot {

    @Autowired
    PersonService personService;
    @Test
    public void test(){
        try {
            personService.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
