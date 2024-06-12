package com.bpkh.services.tiket;

import com.bpkh.model.dto.request.tiket.GetTiketRequestDto;
import com.bpkh.model.dto.request.tiket.ListAddTiketRequestDto;
import com.bpkh.model.dto.request.tiket.ListUpdateTiketRequestDto;
import com.bpkh.model.dto.response.tiket.ListTiketResponseDto;
import com.bpkh.model.dto.response.tiket.TiketResponseDto;

public interface TiketService {

    ListTiketResponseDto getTiket(Long id);

    TiketResponseDto addTiket(ListAddTiketRequestDto request);

    TiketResponseDto updateTiket(ListUpdateTiketRequestDto request);

    TiketResponseDto deleteTiket(Long id);

    TiketResponseDto searchTiket(GetTiketRequestDto request);
}
