package com.shantom.hello;

import com.shantom.hello.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class HelloApplicationTests {

    @Resource
    Person person;

    @Test
    void contextLoads() {
        System.out.println(person);
    }

}
