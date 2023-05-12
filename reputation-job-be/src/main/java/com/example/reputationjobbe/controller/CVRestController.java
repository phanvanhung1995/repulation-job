package com.example.reputationjobbe.controller;

import com.example.reputationjobbe.dto.ICVDto;
import com.example.reputationjobbe.service.ICVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/candidate/cv")
public class CVRestController {
    @Autowired
    private ICVService cvService;

    @GetMapping("/list")
    public ResponseEntity<Page<ICVDto>> getAllCV(@RequestParam(defaultValue = "", required = false) String name,
                                                      @PageableDefault(size = 6, page = 0) Pageable pageable) {
        Page<ICVDto> icvDtoPage = cvService.getAllCV(name, pageable);
        if (icvDtoPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(icvDtoPage, HttpStatus.OK);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<ICVDto> getTeacherById(@PathVariable Long id) {
        Optional<ICVDto> optionalICVDto = cvService.getCvById(id);
        return optionalICVDto.map(CV -> new ResponseEntity<>(CV, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
