package com.bpkh.services.penumpang;

import com.bpkh.model.dto.request.penumpang.ListAddPenumpangRequestDto;
import com.bpkh.model.dto.request.penumpang.ListUpdatePenumpangRequestDto;
import com.bpkh.model.dto.response.penumpang.PenumpangResponseDto;

public interface PenumpangService {
    PenumpangResponseDto addPenumpang(ListAddPenumpangRequestDto request);

    PenumpangResponseDto getPenumpang(Long request);

    PenumpangResponseDto updatePenumpang(ListUpdatePenumpangRequestDto request);

    PenumpangResponseDto deletePenumpang(Long id);
}
