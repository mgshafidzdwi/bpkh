package com.bpkh.model.dto.request.tiket;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)

@Setter
@Getter
@ToString
public class AddTiketRequestDto {
    private Long idPenumpang;
    private Long idTravel;
    private LocalDateTime jadwal;
}