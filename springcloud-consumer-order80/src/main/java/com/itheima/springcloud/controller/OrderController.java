package com.itheima.springcloud.controller;

import com.itheima.springcloud.pojo.CommonResult;
import com.itheima.springcloud.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        log.info("支付信息："+payment);
       return restTemplate.postForObject(PAYMENT_URL+"/payment/insertPayment",payment,CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/getPaymentById/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/getPaymentById/"+id,CommonResult.class);
    }


}
