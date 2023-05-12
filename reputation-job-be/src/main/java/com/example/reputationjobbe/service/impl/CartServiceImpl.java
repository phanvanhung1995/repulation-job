package com.example.reputationjobbe.service.impl;

import com.example.reputationjobbe.dto.ICartDto;
import com.example.reputationjobbe.dto.IOrdersDto;
import com.example.reputationjobbe.model.Cart;
import com.example.reputationjobbe.model.Orders;
import com.example.reputationjobbe.repository.ICartRepository;
import com.example.reputationjobbe.repository.IOderRepository;
import com.example.reputationjobbe.service.ICartService;
import com.example.reputationjobbe.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CartServiceImpl implements ICartService {
    @Autowired
    private ICartRepository cartRepository;
    @Autowired
    private IOderRepository oderRepository;

    @Override
    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public List<ICartDto> getAllCart(Long candidateId) {
        return cartRepository.getAllCart(candidateId);
    }

    @Override
    public Cart getCartById(Long id) {
        return cartRepository.findById(id).orElse(null);
    }

    @Override
    public List<IOrdersDto> getAllOrders(Long candidateId) {
        return oderRepository.getAllOrders(candidateId);
    }

    @Override
    public void delete(Long id) {
        cartRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        cartRepository.deleteAll();
    }

    @Transactional
    public void updateUserAndDeleteCart(Long candidateId) {
        try {
            // Bắt đầu giao dịch
            cartRepository.update(candidateId);
            cartRepository.deleteAllCard(candidateId);

        } catch (Exception e) {
            // Rollback giao dịch (nếu có lỗi xảy ra)
        }
    }
}
