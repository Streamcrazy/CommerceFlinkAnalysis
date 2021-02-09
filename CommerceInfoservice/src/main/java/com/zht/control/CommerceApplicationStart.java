package com.zht.control;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author : Zht
 * @Organization : U know Who
 * @Title :
 * @Description :
 * @Date : 2021/2/79:31
 */
@SpringBootApplication
@ComponentScan({"com.zht"})
public class CommerceApplicationStart {

    public static void main(String[] args) {
        SpringApplication.run(CommerceApplicationStart.class, args);
    }
}
