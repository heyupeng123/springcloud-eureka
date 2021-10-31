package com.itheima.springcloud.service.impl;

import com.itheima.springcloud.mapper.PaymentMapper;
import com.itheima.springcloud.pojo.Payment;
import com.itheima.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public Payment findPaymentById(Long id) {
        Payment payment = paymentMapper.selectByPrimaryKey(id);
        return payment;
    }

    @Override
    public int insertSelective(Payment record) {
        int result = paymentMapper.insertSelective(record);
        return result;
    }

}
