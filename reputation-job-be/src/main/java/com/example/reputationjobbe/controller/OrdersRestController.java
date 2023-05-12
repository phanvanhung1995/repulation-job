package com.example.reputationjobbe.controller;

import com.example.reputationjobbe.dto.ICVDto;
import com.example.reputationjobbe.dto.ICartDto;
import com.example.reputationjobbe.dto.IOrdersDto;
import com.example.reputationjobbe.model.CV;
import com.example.reputationjobbe.model.Candidate;
import com.example.reputationjobbe.model.Cart;
import com.example.reputationjobbe.model.Orders;
import com.example.reputationjobbe.service.impl.CVServiceImpl;
import com.example.reputationjobbe.service.impl.CandidateImpl;
import com.example.reputationjobbe.service.impl.CartServiceImpl;
import com.example.reputationjobbe.service.impl.OrdersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api/candidate/cart")
@CrossOrigin("*")
public class OrdersRestController {
    @Autowired
    private OrdersServiceImpl orderService;
    @Autowired
    private CVServiceImpl cvService;
    @Autowired
    private CandidateImpl candidateService;
    @Autowired
    private CartServiceImpl cartService;

    @GetMapping("/save/{cvId}/{candidateId}")
    public ResponseEntity<?> addCart(@PathVariable Long cvId,
                                     @PathVariable Long candidateId) {
        List<ICartDto> iCartDtos = cartService.getAllCart(candidateId);
        for (ICartDto cart : iCartDtos) {
            if (cart.getCvId().equals(cvId)) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        Candidate candidate = candidateService.findCandidateById(candidateId);
        CV cv = cvService.findById(cvId);

        Orders orders = new Orders();
        orders.setCandidate(candidate);
        Date date = new Date();
        orders.setDatePurchase(date);
        orders.setOrderCode(String.valueOf((int) (Math.random() * 9999) + 1));
        orderService.save(orders);
        Cart cart = new Cart();
        cart.setOrder(orders);
        cart.setCv(cv);
        cart.setQuantity(1);
        Cart cart1 = cartService.save(cart);
        return new ResponseEntity<>(cart1, HttpStatus.CREATED);
    }

    @GetMapping("/list/{candidateId}")
    public ResponseEntity<?> showListCart(@PathVariable Long candidateId) {
        List<ICartDto> iCartDtos = cartService.getAllCart(candidateId);

        return new ResponseEntity<>(iCartDtos, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCart(@PathVariable Long id) {
        Cart cart = cartService.getCartById(id);
        if (cart == null) {
            return ResponseEntity.notFound().build();
        }
        cartService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll/{candidateId}")
    public ResponseEntity<?> updateAndDeleteCart(@PathVariable Long candidateId) {
        cartService.updateUserAndDeleteCart(candidateId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/history/{candidateId}")
    public ResponseEntity<List<IOrdersDto>> getAllCV(@PathVariable Long candidateId) {
        List<IOrdersDto> ordersList = cartService.getAllOrders(candidateId);
        return new ResponseEntity<>(ordersList, HttpStatus.OK);
    }
}
