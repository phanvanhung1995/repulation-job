package com.example.reputationjobbe.repository;

import com.example.reputationjobbe.dto.ICVDto;
import com.example.reputationjobbe.dto.ICandidateDto;
import com.example.reputationjobbe.model.Account;
import com.example.reputationjobbe.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {
    @Query(value = "select a.* from  account as a where a.username= :email", nativeQuery = true)
    Account findAccountByEmail(@Param("email") String email);

    Account findByUsernameContaining(String userName);

    @Query(value = "select `c`.id as id, `c`.address as address, `c`.date_of_birth as dateOfBirth, `c`.email as email, `c`.gender as gender, `c`.id_card as idCard, `c`.name as name, `c`.phone_number as phoneNumber from `account` a \n" +
            "join `candidate` c on `c`.id = `a`.candidate_id\n" +
            "where `a`.candidate_id = :id", nativeQuery = true)
    Optional<ICandidateDto> getCandidateById(@Param("id") Long id);
}
