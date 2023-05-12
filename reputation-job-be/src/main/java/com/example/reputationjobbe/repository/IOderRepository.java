package com.example.reputationjobbe.repository;

import com.example.reputationjobbe.dto.IOrdersDto;
import com.example.reputationjobbe.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOderRepository extends JpaRepository<Orders, Long> {
    @Query(value = "select `orders`.id as id, `orders`.order_code as code, `orders`.date_purchase as date,`img_cv`.link as link ,`cv`.price as price,`cv`.name as name \n" +
            "from `orders` \n" +
            "join `cart` on `cart`.order_id = `orders`.id\n" +
            "join `cv` on `cv`.id = `cart`.cv_id\n" +
            "join `img_cv` on `cv`.id = `img_cv`.cv_id\n" +
            "where `orders`.is_paid = 1 and `orders`.candidate_id  = :candidateId ;", nativeQuery = true)
    List<IOrdersDto> getAllOrders(@Param("candidateId") Long candidateId);



}
