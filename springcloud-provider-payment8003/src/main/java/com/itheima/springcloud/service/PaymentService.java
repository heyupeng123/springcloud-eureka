package com.itheima.springcloud.service;

import com.itheima.springcloud.pojo.Payment;

public interface PaymentService {
    /**
     * 根据id查询用户信息
     * @param id
     * @return 支付对象
     */
    Payment findPaymentById(Long id);

    int insertSelective(Payment record);
}
