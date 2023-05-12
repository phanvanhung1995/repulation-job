package com.example.reputationjobbe.repository;

import com.example.reputationjobbe.dto.ICartDto;
import com.example.reputationjobbe.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ICartRepository extends JpaRepository<Cart, Long> {
    @Query(value = "select `cart`.id as id,`cv`.name as name,`img_cv`.link as link,`cv`.price as price, `cart`.quantity as quantity, `cv`.file_path  as filePath,`cv`.id   as cvId  from `cart` \n" +
            "join `cv` on `cart`.cv_id = `cv`.id \n" +
            "join `orders` on `orders`.id = `cart`.order_id\n" +
            "join `img_cv` on `img_cv`.cv_id = `cv`.id\n" +
            "join `candidate` on `candidate`.id = `orders`.candidate_id\n" +
            "where `candidate`.id = :candidateId and `orders`.is_paid =0 ", nativeQuery = true)
    List<ICartDto> getAllCart(@Param("candidateId") Long candidateId);

    @Transactional
    @Modifying
    @Query(value = "update `orders` set is_paid = 1 where candidate_id = :candidateId", nativeQuery = true)
    void update(@Param("candidateId") Long id);

    @Transactional
    @Modifying
    @Query(value = "update cart \n" +
            "join orders on orders.id = cart.order_id\n" +
            "set cart.flag_delete =1 where orders.candidate_id = :candidateId", nativeQuery = true)
    void deleteAllCard(@Param("candidateId") Long candidateId);
}
