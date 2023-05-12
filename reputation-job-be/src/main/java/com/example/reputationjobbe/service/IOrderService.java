package com.example.reputationjobbe.service;


import com.example.reputationjobbe.model.Orders;
import org.springframework.stereotype.Service;

@Service
public interface IOrderService {
    Orders save(Orders orders);
}
