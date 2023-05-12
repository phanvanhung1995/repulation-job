package com.example.reputationjobbe.service;

import com.example.reputationjobbe.dto.ICartDto;
import com.example.reputationjobbe.dto.IOrdersDto;
import com.example.reputationjobbe.model.Cart;
import java.util.List;

public interface ICartService  {
    Cart save(Cart cart);

    List<ICartDto> getAllCart(Long candidateId);

    void delete(Long id);
    void deleteAll();
    Cart getCartById(Long id);

    List<IOrdersDto> getAllOrders(Long candidateId);
}
