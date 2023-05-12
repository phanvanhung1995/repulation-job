package com.example.reputationjobbe.service.impl;

import com.example.reputationjobbe.model.Orders;
import com.example.reputationjobbe.repository.IOderRepository;
import com.example.reputationjobbe.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements IOrderService {
    @Autowired
    private IOderRepository oderRepository;
    @Override
    public Orders save(Orders orders) {
        return oderRepository.save(orders);
    }
}
