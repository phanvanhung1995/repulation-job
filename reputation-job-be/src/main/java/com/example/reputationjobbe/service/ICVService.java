package com.example.reputationjobbe.service;

import com.example.reputationjobbe.dto.ICVDto;
import com.example.reputationjobbe.model.CV;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface ICVService {
    Page<ICVDto> getAllCV(String name, Pageable pageable);

    Optional<ICVDto> getCvById(Long id);
    CV findById(Long id);
}
