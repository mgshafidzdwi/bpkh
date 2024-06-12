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

import com.bpkh.model.dto.request.tiket.GetTiketRequestDto;
import com.bpkh.model.dto.request.tiket.ListAddTiketRequestDto;
import com.bpkh.model.dto.request.tiket.ListUpdateTiketRequestDto;
import com.bpkh.model.dto.response.tiket.ListTiketResponseDto;
import com.bpkh.model.dto.response.tiket.TiketResponseDto;
import com.bpkh.services.tiket.TiketService;

@RestController
@RequestMapping("/api/v1/tiket")
public class TiketController {

    @Autowired
    private TiketService tiketService;

    @GetMapping("/get/{id}")
    public ResponseEntity<ListTiketResponseDto> getTravel(@PathVariable Long id) {
        return ResponseEntity.ok(tiketService.getTiket(id));
    }

    @PostMapping("/add")
    public ResponseEntity<TiketResponseDto> addTiket(@RequestBody ListAddTiketRequestDto request) {
        return ResponseEntity.ok(tiketService.addTiket(request));
    }

    @PostMapping("/update")
    public ResponseEntity<TiketResponseDto> updateTiket(@RequestBody ListUpdateTiketRequestDto request) {
        return ResponseEntity.ok(tiketService.updateTiket(request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<TiketResponseDto> deleteTiket(@PathVariable Long id) {
        return ResponseEntity.ok(tiketService.deleteTiket(id));
    }

    @PostMapping("/search")
    public ResponseEntity<TiketResponseDto> searchTiket(@RequestBody GetTiketRequestDto request) {
        return ResponseEntity.ok(tiketService.searchTiket(request));
    }
}
