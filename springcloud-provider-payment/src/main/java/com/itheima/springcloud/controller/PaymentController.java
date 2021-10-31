package com.itheima.springcloud.controller;

import com.itheima.springcloud.pojo.CommonResult;
import com.itheima.springcloud.pojo.Payment;
import com.itheima.springcloud.service.PaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/payment/getPaymentById/{id}")
    public @ResponseBody CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.findPaymentById(id);
        if (payment != null){
            return new CommonResult(200,"查询成功！",payment);
        }else {
            return new CommonResult(444,"查询失败");
        }
    }

    @PostMapping(value = "/payment/insertPayment")
    public @ResponseBody CommonResult insertPayment(@RequestBody Payment payment){
        int result = paymentService.insertSelective(payment);
        if (result > 0){
            return new CommonResult(200,"添加成功！",result);
        }else {
            return new CommonResult(444,"添加失败！");
        }
    }
}
