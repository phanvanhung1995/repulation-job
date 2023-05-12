package com.example.reputationjobbe.service;

import com.example.reputationjobbe.dto.ICVDto;
import com.example.reputationjobbe.dto.ICandidateDto;
import com.example.reputationjobbe.model.Candidate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ICandidateService {
    Page<ICandidateDto> getAllCandidate(String name, Pageable pageable);

    Optional<ICandidateDto> getCandidateById(Long id);
    Candidate findCandidateById(Long id);
    Candidate updateCandidate(Candidate candidate);
}
