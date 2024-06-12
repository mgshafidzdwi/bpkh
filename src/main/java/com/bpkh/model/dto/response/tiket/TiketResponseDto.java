package com.bpkh.model.dto.response.tiket;

import java.time.LocalDateTime;

import com.bpkh.model.dto.response.common.BpkhResponseDto;
import com.bpkh.model.dto.response.penumpang.PenumpangDto;
import com.bpkh.model.dto.response.travel.TravelDto;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
@ToString
public class TiketResponseDto extends BpkhResponseDto {
    private LocalDateTime jadwal;
    private PenumpangDto penumpang;
    private TravelDto travel;
}
