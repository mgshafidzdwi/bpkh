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

import com.bpkh.model.dto.request.travel.GetTravelRequestDto;
import com.bpkh.model.dto.request.travel.ListAddTravelRequestDto;
import com.bpkh.model.dto.request.travel.ListUpdateTravelRequestDto;
import com.bpkh.model.dto.response.travel.TravelResponseDto;
import com.bpkh.services.travel.TravelService;

@RestController
@RequestMapping("/api/v1/travel")
public class TravelController {

    @Autowired
    private TravelService travelService;

    @PostMapping("/add")
    public ResponseEntity<TravelResponseDto> addTravel(@RequestBody ListAddTravelRequestDto request) {
        return ResponseEntity.ok(travelService.addTravel(request));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<TravelResponseDto> getTravel(@PathVariable Long id) {
        return ResponseEntity.ok(travelService.getTravel(id));
    }

    @PostMapping("/update")
    public ResponseEntity<TravelResponseDto> updateTravel(@RequestBody ListUpdateTravelRequestDto request) {
        return ResponseEntity.ok(travelService.updateTravel(request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<TravelResponseDto> deleteTravel(@PathVariable Long id) {
        return ResponseEntity.ok(travelService.deleteTravel(id));
    }

    @PostMapping("/search")
    public ResponseEntity<TravelResponseDto> searchTravel(@RequestBody GetTravelRequestDto request) {
        return ResponseEntity.ok(travelService.searchTravel(request));
    }
}
