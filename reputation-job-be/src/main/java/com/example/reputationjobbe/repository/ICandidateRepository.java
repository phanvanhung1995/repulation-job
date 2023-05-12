package com.example.reputationjobbe.repository;

import com.example.reputationjobbe.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICandidateRepository extends JpaRepository<Candidate,Long> {

}
