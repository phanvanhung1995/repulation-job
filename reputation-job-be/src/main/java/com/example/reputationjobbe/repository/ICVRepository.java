package com.example.reputationjobbe.repository;

import com.example.reputationjobbe.dto.ICVDto;
import com.example.reputationjobbe.model.CV;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface ICVRepository extends JpaRepository<CV, Long> {

    @Query(value = "select `cv`.id as id,`img_cv`.link as link, `cv`.description as description,`cv`.file_path as filePath,`cv`.name as name, `cv`.price as price, `position`.name as position\n" +
            "from `cv` \n" +
            "join `position` on `position`.id = `cv`.position_id\n" +
            "join `img_cv` on `img_cv`.cv_id = `cv`.id\n" +
            "where `cv`.name like concat('%',:nameSearch,'%')", nativeQuery = true)
    Page<ICVDto> getAllCV(@Param("nameSearch") String name, Pageable pageable);

    @Query(value = "select `cv`.id as id, `img_cv`.link as link,`cv`.description as description,`cv`.file_path as filePath,`cv`.name as name, `cv`.price as price, `position`.name as position\n" +
            "from `cv` \n" +
            "join `position` on `position`.id = `cv`.position_id\n" +
            "join `img_cv` on `img_cv`.cv_id = `cv`.id\n" +
            "where `cv`.id = :id", nativeQuery = true)
    Optional<ICVDto> getAllById(@Param("id") Long id);


}
