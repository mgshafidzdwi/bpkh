package com.bpkh.services.travel;

import com.bpkh.model.dto.request.travel.GetTravelRequestDto;
import com.bpkh.model.dto.request.travel.ListAddTravelRequestDto;
import com.bpkh.model.dto.request.travel.ListUpdateTravelRequestDto;
import com.bpkh.model.dto.response.travel.TravelResponseDto;

public interface TravelService {
    TravelResponseDto addTravel(ListAddTravelRequestDto request);

    TravelResponseDto getTravel(Long id);

    TravelResponseDto updateTravel(ListUpdateTravelRequestDto request);

    TravelResponseDto deleteTravel(Long id);

    TravelResponseDto searchTravel(GetTravelRequestDto request);
}
