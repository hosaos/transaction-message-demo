package com.company.project.biz.controller;

import com.company.project.biz.TransactionProducer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chenyin
 * @since 2019-05-10
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    private TransactionProducer transactionProducer;

    @RequestMapping("/mqTest")
    public String callback(String data) {
        transactionProducer.test();
        return "Ok";
    }

}
