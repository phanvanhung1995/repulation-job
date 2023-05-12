package com.example.reputationjobbe.service.impl;

import com.example.reputationjobbe.dto.ICandidateDto;
import com.example.reputationjobbe.model.Candidate;
import com.example.reputationjobbe.repository.IAccountRepository;
import com.example.reputationjobbe.repository.ICandidateRepository;
import com.example.reputationjobbe.service.ICandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CandidateImpl implements ICandidateService {
    @Autowired
    private IAccountRepository accountRepository;
    @Autowired
    private ICandidateRepository candidateRepository;

    @Override
    public Page<ICandidateDto> getAllCandidate(String name, Pageable pageable) {
        return null;
    }

    @Override
    public Optional<ICandidateDto> getCandidateById(Long id) {
        return accountRepository.getCandidateById(id);
    }

    @Override
    public Candidate findCandidateById(Long id) {
        return candidateRepository.findById(id).orElse(null);
    }

    @Override
    public Candidate updateCandidate(Candidate candidate) {
       return candidateRepository.save(candidate);
    }
}
