package com.bpkh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bpkh.model.dto.request.penumpang.ListAddPenumpangRequestDto;
import com.bpkh.model.dto.request.penumpang.ListUpdatePenumpangRequestDto;
import com.bpkh.model.dto.response.penumpang.PenumpangResponseDto;
import com.bpkh.services.penumpang.PenumpangService;

@RestController
@RequestMapping("/api/v1/penumpang")
public class PenumpangController {

    @Autowired
    private PenumpangService penumpangService;

    @PostMapping("/add")
    public ResponseEntity<PenumpangResponseDto> addPenumpang(@RequestBody ListAddPenumpangRequestDto request) {
        return ResponseEntity.ok(penumpangService.addPenumpang(request));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PenumpangResponseDto> getPenumpang(@PathVariable Long id) {
        return ResponseEntity.ok(penumpangService.getPenumpang(id));
    }

    @PostMapping("/update")
    public ResponseEntity<PenumpangResponseDto> updatePenumpang(@RequestBody ListUpdatePenumpangRequestDto request) {
        return ResponseEntity.ok(penumpangService.updatePenumpang(request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PenumpangResponseDto> deletePenumpang(@PathVariable Long id) {
        return ResponseEntity.ok(penumpangService.deletePenumpang(id));
    }
}
