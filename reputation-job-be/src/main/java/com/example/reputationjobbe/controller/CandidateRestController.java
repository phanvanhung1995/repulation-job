package com.example.reputationjobbe.controller;
import com.example.reputationjobbe.dto.ICandidateDto;
import com.example.reputationjobbe.model.Candidate;
import com.example.reputationjobbe.service.impl.CandidateImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/candidate")
public class CandidateRestController {
    @Autowired
    private CandidateImpl candidateService;

    @GetMapping("/list/{id}")
    public ResponseEntity<ICandidateDto> getTeacherById(@PathVariable Long id) {
        Optional<ICandidateDto> candidateDto = candidateService.getCandidateById(id);
        return candidateDto.map(CV -> new ResponseEntity<>(CV, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PatchMapping("/update")
    public ResponseEntity updateCandidate( @Validated @RequestBody Candidate candidate, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
       Candidate candidate1 = candidateService.updateCandidate(candidate);
        return new ResponseEntity(candidate1,HttpStatus.OK);
    }
}
